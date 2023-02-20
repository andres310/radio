package com.example.radio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity3 : AppCompatActivity() {
    var sensacion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }

    override fun onStart() {
        super.onStart()

        // Recupera el componente
        val rgSensacion = findViewById<RadioGroup>(R.id.rg_sensacion)

        // Almacena id de la respuesta, default -1 para indicar que no hay respuesta
        var rSensacion =  -1

        // Evento de seleccion de la respuesta
        rgSensacion.setOnCheckedChangeListener { group, checkedId -> rSensacion = checkedId }

        // Recupera componentes de respuesta
        val feliz = findViewById<RadioButton>(R.id.feliz)
        val triste = findViewById<RadioButton>(R.id.triste)
        val desesperado = findViewById<RadioButton>(R.id.desesperado)
        val tranquilo = findViewById<RadioButton>(R.id.tranquilo)

        // Almacena el resultado
        rgSensacion.setOnCheckedChangeListener { group, checkedId ->
            rSensacion = checkedId
            when (rSensacion) {
                feliz.id -> this.sensacion = feliz.text.toString()
                triste.id -> this.sensacion = triste.text.toString()
                desesperado.id -> this.sensacion = desesperado.text.toString()
                tranquilo.id -> this.sensacion = tranquilo.text.toString()
            }
        }


        // Exporta variable a siguiente vista
        val btnSig = findViewById<Button>(R.id.btn_sig3)
        btnSig.setOnClickListener {
            val intent = Intent(this@MainActivity3, MainActivity4::class.java)
            val genero = this.intent.getStringExtra("genero")
            val estadoCivil = this.intent.getStringExtra("estadoCivil")
            intent.putExtra("genero", genero)
            intent.putExtra("estadoCivil", estadoCivil)
            intent.putExtra("sensacion", this.sensacion)
            startActivity(intent)
        }

        // TO DO
    }
}