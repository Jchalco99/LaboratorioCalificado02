package com.chalco.jose.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chalco.jose.laboratoriocalificado02.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre")
        val numero = intent.getStringExtra("numero")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")

        binding.textNombre.text = nombre
        binding.textNumero.text = numero
        binding.textProductos.text = productos
        binding.textUbicacion.text = direccion

        binding.btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numero")
            }
            startActivity(intent)
        }

        binding.btnWsp.setOnClickListener {
            val mensaje = "Hola $nombre, Tus productos: $productos están en camino a la dirección: $direccion"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://api.whatsapp.com/send?phone=$numero&text=$mensaje")
            }
            startActivity(intent)
        }

        binding.btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccion"))
            startActivity(intent)
        }
    }
}