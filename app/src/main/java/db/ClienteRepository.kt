package db

import android.content.Context
import db.ConstantDb.CONTATOS_TABLE_NAME
import org.jetbrains.anko.db.*

class ClienteRepository (val context: Context) {

    fun findAll() : ArrayList<Cliente> = context.database.use {
        val contatos = ArrayList<Cliente>()

        select(CONTATOS_TABLE_NAME, "id", "email", "endereco", "nome", "telefone")
            .parseList(object: MapRowParser<List<Cliente>> {
                override fun parseRow(columns: Map<String, Any?>): List<Cliente> {
                    val id = columns.getValue("id")
                    val email = columns.getValue("email")
                    val endereco = columns.getValue("endereco")
                    val nome = columns.getValue("nome")
                    val telefone = columns.getValue("telefone")

                    val contato = Cliente(
                        id.toString()?.toInt(),
                        nome?.toString(),
                        endereco?.toString(),
                        telefone?.toString(),
                        email?.toString())

                    contatos.add(contato)
                    return contatos
                }
            })

        contatos


    }

    fun create(contato: Cliente) = context.database.use {

        insert(CONTATOS_TABLE_NAME,
            "nome" to contato.nome,
            "endereco" to contato.endereco,
            "telefone" to contato.telefone,
            "email" to contato.email)

    }

    fun update(contato: Cliente) = context.database.use {
        val updateResult = update(CONTATOS_TABLE_NAME,
            "nome" to contato.nome,
            "endereco" to contato.endereco,
            "telefone" to contato.telefone,
            "email" to contato.email)
            .whereArgs("id = {id}","id" to contato.id).exec()

        //Timber.d("Update result code is $updateResult")

    }

    fun delete(id: Long) = context.database.use {

        delete(CONTATOS_TABLE_NAME, "id = {contatoId}", "contatoId" to id)

    }
}