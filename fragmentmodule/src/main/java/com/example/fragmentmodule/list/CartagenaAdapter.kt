package com.example.fragmentmodule.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentmodule.R
import com.example.fragmentmodule.model.CartagenaItem
import com.squareup.picasso.Picasso

class CartagenaAdapter(
    private val cartagenaList: ArrayList<CartagenaItem>,
    private val onItemClicked: (CartagenaItem) -> Unit
    ) : RecyclerView.Adapter<CartagenaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_cartagena_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartagena = cartagenaList[position]
        holder.itemView.setOnClickListener {onItemClicked(cartagenaList[position])}
        holder.bind(cartagena)
    }

    override fun getItemCount(): Int {
        return cartagenaList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descripcortaTextView: TextView = itemView.findViewById(R.id.descripcorta_text_view)
        private var puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        private var picImageView: ImageView = itemView.findViewById(R.id.pic_image_view)

        fun bind(cartagena: CartagenaItem){
            nameTextView.text = cartagena.nombre
            descripcortaTextView.text = cartagena.descripCorta
            puntuacionTextView.text = cartagena.puntuacion
            Picasso.get().load(cartagena.urlpic).into(picImageView);
        }
    }
}