package com.example.radio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity2 : AppCompatActivity() {
    var estadoCivil = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onStart() {
        super.onStart()

        // Recupera el componente
        val rgEstadoCivil = findViewById<RadioGroup>(R.id.rg_estadocivil)

        // Alnacena id de la respuesta, default -1
        var rEstadoCivil = -1

        // Evento de seleccion del grupo
        rgEstadoCivil.setOnCheckedChangeListener { group, checkedId ->  rEstadoCivil = checkedId }

        // Recupera componentes de respuesta
        val soltero = findViewById<RadioButton>(R.id.soltero)
        val casado = findViewById<RadioButton>(R.id.casado)
        val rejuntado = findViewById<RadioButton>(R.id.rejuntado)

        // Almacena el resultado
        rgEstadoCivil.setOnCheckedChangeListener { group, checkedId ->
            rEstadoCivil = checkedId
            when (rEstadoCivil) {
                soltero.id -> this.estadoCivil = soltero.text.toString()
                casado.id -> this.estadoCivil = casado.text.toString()
                rejuntado.id -> this.estadoCivil = rejuntado.text.toString()
            }
        }

        // Recupera boton de siguiente a view 3
        val btnSig = findViewById<Button>(R.id.btn_sig2)

        btnSig.setOnClickListener {
            // Valida que haya respuestas antes de pasar a la siguiente view


            // Le pasa datos a la siguiente view
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            val genero = this.intent.getStringExtra("genero")
            intent.putExtra("genero", genero)
            intent.putExtra("estadoCivil", this.estadoCivil)
            startActivity(intent)
        }


        // Exportado el resultado a la siguiente vista

        // TO DO

    }
}