package com.example.fragmentmodule.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CartagenaItem(
    @SerializedName("descripCorta")
    val descripCorta: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlpic")
    val urlpic: String,
    @SerializedName("contenido")
    val contenido: String,
    @SerializedName("temperatura")
    val temperatura: String
) : Serializable