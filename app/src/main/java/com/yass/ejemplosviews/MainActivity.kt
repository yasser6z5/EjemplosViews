package com.yass.ejemplosviews

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<EditText>(R.id.etName)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()

        btnSaludar.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isNotEmpty()) {
                tvResult.text = "Hola, $name"
            } else {
                tvResult.text = "No te saludo brother"
            }
        }
    }
}
