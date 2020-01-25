package com.example.limpeza

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import db.Cliente
import db.ClienteRepository
import kotlinx.android.synthetic.main.activity_cliente.*
import java.util.*

class ClienteActivity : AppCompatActivity() {

    var cliente: Cliente? = null
    override fun onResume() {
        super.onResume()
        val intent = intent

        if(intent != null){
            if(intent.getSerializableExtra("cliente") != null){
                cliente = intent.getSerializableExtra("cliente") as Cliente

                txtNome?.setText(cliente?.nome)
                txtEndereco?.setText(cliente?.endereco)
                txtTelefone.setText(cliente?.telefone.toString())

                txtEmail.setText(cliente?.email)
            }else{
                cliente = Cliente()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        val myChildToolbar = toolbar_child
        setSupportActionBar(myChildToolbar)

        // Get a support ActionBar corresponding to this toolbar
        val ab = supportActionBar

        // Enable the Up button
        ab!!.setDisplayHomeAsUpEnabled(true)

        if (intent?.getSerializableExtra("cliente") != null) {
            cliente = intent?.getSerializableExtra("cliente") as Cliente
            txtNome?.setText(cliente?.nome)
            txtEndereco?.setText(cliente?.endereco)
            txtTelefone?.setText(cliente?.telefone?.toString())
            txtEmail?.setText(cliente?.email)
        }else{
            cliente = Cliente()
        }




        btnCadastro?.setOnClickListener {

            cliente?.nome = txtNome?.text.toString()
            cliente?.endereco = txtEndereco?.text.toString()
            cliente?.telefone = txtTelefone?.text.toString()
            cliente?.email = txtEmail?.text.toString()

            if(cliente?.id == 0){
                ClienteRepository(this).create(cliente!!)
            }else{
                ClienteRepository(this).update(cliente!!)
            }
            finish()



            /*val contato = Contato(
                foto = "Goto",
                nome = txtNome?.text.toString(),
                endereco = txtEndereco?.text.toString(),
                telefone = txtTelefone?.text.toString(),
                dataNascimento =  cal.toString(),
                email =  txtEmail?.text.toString(),
                site =  txtSite?.text.toString())

            ContatoRepository(this).create(contato)
            finish()*/
        }



    }


}
