package com.example.radio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    var genero = ""

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

        // Almacenan ids de las respuestas
        var rGenero = -1

        // Eventos de seleccion de los grupos
        rgGenero.setOnCheckedChangeListener { radioGroup, checkedId -> rGenero = checkedId }

        // Recupera componentes de respuestas
        val hombre = findViewById<RadioButton>(R.id.hombre)
        val mujer = findViewById<RadioButton>(R.id.mujer)

        // Encontrando respuestas del usuario

        // Recupera el boton
        val btnSig = findViewById<Button>(R.id.btn_sig3)

        // Muestra el resultado al hacer click sobre el boton
        btnSig.setOnClickListener {
            // Establece las respuestas
            when (rGenero) {
                hombre.id -> this.genero = hombre.text.toString()
                mujer.id -> this.genero = mujer.text.toString()
            }

            // Valida que hayan respuestas para pasar a la siguiente view
            // TO DO

            // Pasa a la siguiente view
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("genero", this.genero)
            startActivity(intent)


//            // Muestra mensaje con resultados
//            Snackbar.make(btnResultado, "${this.genero} ${this.sensacion}", Snackbar.LENGTH_INDEFINITE)
//                .show()
        }
    }


}