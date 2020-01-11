package com.example.limpeza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_cliente.*

class ClienteActivity : AppCompatActivity() {


    private var txtNome: EditText? = null
    private var txtEndereco: EditText? = null
    private var txtTelefone: EditText? = null
    private var btnCadastro: Button? = null
    private var txtEmail: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        val myChildToolbar = toolbar_child
        setSupportActionBar(myChildToolbar)

        // Get a support ActionBar corresponding to this toolbar
        val ab = supportActionBar

        // Enable the Up button
        ab!!.setDisplayHomeAsUpEnabled(true)

        txtNome = txtNome
        txtEndereco = txtEndereco
        txtTelefone = txtTelefone
        txtEmail = txtEmail
        btnCadastro = btnCadastro
    }
}
