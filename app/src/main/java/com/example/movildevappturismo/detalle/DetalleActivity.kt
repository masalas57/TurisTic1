package com.example.movildevappturismo.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movildevappturismo.databinding.ActivityDetalleBinding
import com.example.movildevappturismo.model.BogotaItem

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val bogota: BogotaItem = intent.extras?.getSerializable("bogota") as BogotaItem
        detalleBinding.nombreTextView.text = bogota.nombre

    }
}