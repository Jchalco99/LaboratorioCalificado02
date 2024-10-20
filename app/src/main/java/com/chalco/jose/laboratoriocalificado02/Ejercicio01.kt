package com.chalco.jose.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.chalco.jose.laboratoriocalificado02.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            binding.greenView.visibility = View.VISIBLE
        }

        binding.btnHide.setOnClickListener {
            binding.greenView.visibility = View.GONE
        }
    }
}