package com.example.movildevappturismo.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movildevappturismo.R
import com.example.movildevappturismo.model.BogotaItem
import com.squareup.picasso.Picasso

class BogotaAdapter(
    private val bogotaList: ArrayList<BogotaItem>,
    private val onItemClicked: (BogotaItem) -> Unit
    ) : RecyclerView.Adapter<BogotaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_bogota_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bogota = bogotaList[position]
        holder.itemView.setOnClickListener {onItemClicked(bogotaList[position])}
        holder.bind(bogota)
    }

    override fun getItemCount(): Int {
        return bogotaList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descripcortaTextView: TextView = itemView.findViewById(R.id.descripcorta_text_view)
        private var puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        private var picImageView: ImageView = itemView.findViewById(R.id.pic_image_view)

        fun bind(bogota: BogotaItem){
            nameTextView.text = bogota.nombre
            descripcortaTextView.text = bogota.descripCorta
            puntuacionTextView.text = bogota.puntuacion
            Picasso.get().load(bogota.urlpic).into(picImageView);
        }
    }
}