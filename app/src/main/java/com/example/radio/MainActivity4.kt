package com.example.radio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
    }

    override fun onStart() {
        super.onStart()

        val txtResultado = findViewById<TextView>(R.id.txt_resultado)

        // Recupera respuestas anteriores
        val genero = this.intent.getStringExtra("genero")
        val estadoCivil = this.intent.getStringExtra("estadoCivil")
        val sensacion = this.intent.getStringExtra("sensacion")

        txtResultado.text = "${genero} ${estadoCivil} ${sensacion}"
    }
}