package com.example.movildevappturismo.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BogotaItem(
    @SerializedName("descripCorta")
    val descripCorta: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlpic")
    val urlpic: String
) : Serializable