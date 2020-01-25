package db

import java.io.Serializable

data class Cliente (
    var id: Int = 0,
    var nome: String? = null,
    var endereco: String? = null,
    var telefone: String? = null,
    var email: String? = null) : Serializable {

    override fun toString(): String {
        return nome.toString()
    }


}