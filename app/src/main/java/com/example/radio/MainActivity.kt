package com.example.radio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var genero = ""
    var estadoCivil = ""
    var sensacion = ""

    companion object{
        const val TAG="Radio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {


        super.onStart()

        // Recupera el componente
        val rgGenero = findViewById<RadioGroup>(R.id.rg_genero)
        val rgEstadoCivil = findViewById<RadioGroup>(R.id.rg_estadocivil)
        val rgSensacion = findViewById<RadioGroup>(R.id.rg_sensacion)

        // Almacenan ids de las respuestas
        var rGenero = -1
        var rEstadoCivil = -1
        var rSensacion =  -1

        // Eventos de seleccion de los grupos
        rgGenero.setOnCheckedChangeListener { radioGroup, checkedId -> rGenero = checkedId }
        rgEstadoCivil.setOnCheckedChangeListener { group, checkedId ->  rEstadoCivil = checkedId }
        rgSensacion.setOnCheckedChangeListener { group, checkedId -> rSensacion = checkedId }

        // Recupera componentes de respuestas
        val hombre = findViewById<RadioButton>(R.id.hombre)
        val mujer = findViewById<RadioButton>(R.id.mujer)
        val soltero = findViewById<RadioButton>(R.id.soltero)
        val casado = findViewById<RadioButton>(R.id.casado)
        val rejuntado = findViewById<RadioButton>(R.id.rejuntado)
        val feliz = findViewById<RadioButton>(R.id.feliz)
        val triste = findViewById<RadioButton>(R.id.triste)
        val desesperado = findViewById<RadioButton>(R.id.desesperado)
        val tranquilo = findViewById<RadioButton>(R.id.tranquilo)

        // Encontrando respuestas del usuario

        // Recupera el boton
        val btnResultado = findViewById<Button>(R.id.btn_resultado)

        // Muestra el resultado al hacer click sobre el boton
        btnResultado.setOnClickListener {
            // Establece las respuestas
            when (rGenero) {
                hombre.id -> this.genero = hombre.text.toString()
                mujer.id -> this.genero = mujer.text.toString()
            }
            when (rEstadoCivil) {
                soltero.id -> this.estadoCivil = soltero.text.toString()
                casado.id -> this.estadoCivil = casado.text.toString()
                rejuntado.id -> this.estadoCivil = rejuntado.text.toString()
            }
            when (rSensacion) {
                feliz.id -> this.sensacion = feliz.text.toString()
                triste.id -> this.sensacion = triste.text.toString()
                desesperado.id -> this.sensacion = desesperado.text.toString()
                tranquilo.id -> this.sensacion = tranquilo.text.toString()
            }
            // Muestra mensaje con resultados
            Snackbar.make(btnResultado, "${this.genero} ${this.estadoCivil} ${this.sensacion}", Snackbar.LENGTH_INDEFINITE)
                .show()
        }
    }


}