package com.chalco.jose.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chalco.jose.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.inputNombre.text.toString()
            val numero = binding.inputNumero.text.toString()
            val productos = binding.inputProductos.text.toString()
            val ciudad = binding.inputCiudad.text.toString()
            val direccion = binding.inputDireccion.text.toString()

            if (nombre.isEmpty() || numero.isEmpty() || productos.isEmpty() || ciudad.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, PedidoActivity::class.java).apply {
                    putExtra("nombre", nombre)
                    putExtra("numero", numero)
                    putExtra("productos", productos)
                    putExtra("ciudad", ciudad)
                    putExtra("direccion", direccion)
                }
                startActivity(intent)
            }
        }
    }
}
