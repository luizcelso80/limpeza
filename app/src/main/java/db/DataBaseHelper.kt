package db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import db.ConstantDb.CONTATOS_DB_NAME
import db.ConstantDb.CONTATOS_TABLE_NAME
import org.jetbrains.anko.db.*

class DataBaseHelper (context: Context) :
    ManagedSQLiteOpenHelper(ctx = context ,
        name = CONTATOS_DB_NAME,  version = 1){



    companion object {
        private var instance: DataBaseHelper? = null



        @Synchronized
        fun getInstance(ctx: Context): DataBaseHelper {
            if (instance == null) {
                instance = DataBaseHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Criação de tabelas
        db.createTable(CONTATOS_TABLE_NAME, true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "nome" to TEXT,
            "endereco" to TEXT,
            "telefone" to TEXT,
            "email" to TEXT
        )


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CONTATOS_TABLE_NAME, true)
        onCreate(db)
    }
}
val Context.database: DataBaseHelper get() = DataBaseHelper.getInstance(getApplicationContext())
