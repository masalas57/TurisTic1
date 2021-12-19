package com.example.movildevappturismo.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movildevappturismo.R
import com.example.movildevappturismo.detalle.DetalleActivity
import com.example.movildevappturismo.model.Bogota
import com.example.movildevappturismo.model.BogotaItem
import com.google.gson.Gson

class ListBogotaActivity : AppCompatActivity() {

    private lateinit var listBogota: ArrayList<BogotaItem>
    private lateinit var bogotaAdapter: BogotaAdapter
    private lateinit var bogotaRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_bogota)

        bogotaRecyclerView = findViewById(R.id.bogota_recycler_view)

       // listBogota = createMockBogota()
        listBogota = loadMockBogotaFromJson()
        bogotaAdapter = BogotaAdapter(listBogota, onItemClicked = { onBogotaClicked(it) } )

       // bogotaRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        bogotaRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = bogotaAdapter
            setHasFixedSize(false)
        }
    }

    private fun onBogotaClicked(bogota: BogotaItem) {
        Log.d("nombre", bogota.nombre)
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("bogota",bogota)
        startActivity(intent)
    }

    private fun loadMockBogotaFromJson(): ArrayList<BogotaItem> {
        var bogotaString: String = applicationContext.assets.open("poibogota.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(bogotaString, Bogota::class.java)
        return data
    }

    /* private fun createMockBogota(): ArrayList<Bogota> {
        return arrayListOf(
            Bogota(
                nombre = "Monserrate",
                descripCorta = "El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad.",
                puntuacion = "Puntuación: 4.5",
                urlpic = "https://monserrate.co/wp-content/uploads/2019/10/cerro-monserrate.jpg"
            ),
            Bogota(
                nombre = "Chorro de Quevedo",
                descripCorta = "Aquí comenzó too: en la plazoleta del Chorro de Quevedo se cree que se fundó Bogotá el 6 de agosto de 1538.",
                puntuacion = "Puntuación: 4",
                urlpic = "https://www.sitiosturisticosbogota.com/wp-content/uploads/2018/11/chorro-de-quevedo.jpg"
            ),
            Bogota(
                nombre = "Plaza de Bolivar",
                descripCorta = "Ubicada en el centro de Bogotá, la Plaza de Bolívar es la principal plaza de la ciudad, siendo declarada como Monumento Nacional Colombiano.",
                puntuacion = "Puntuación: 4.8",
                urlpic = "https://www.utadeo.edu.co/sites/tadeo/files/node/news/field_images/portada.foto_.hanz_.rippe_.idpc_.plaza_.de_.bolivar_0.jpg"
            ),
            Bogota(
                nombre = "Parque Simón Bolívar",
                descripCorta = "El Parque Metropolitano Simón Bolívar es el parque urbano más grande e importante de la ciudad de Bogotá.",
                puntuacion = "Puntuación: 3.8",
                urlpic = "https://bogota.gov.co/sites/default/files/styles/1050px/public/field/image/simon-bolivar.jpg"
            )

        )
    }*/

    }
