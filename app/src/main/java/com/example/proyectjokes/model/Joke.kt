package com.example.proyectjokes.model

import com.google.gson.annotations.SerializedName

class Joke (
    var id: String,
    var source: String,
    var jokeId: String,
    var calificacion: Int,
    @SerializedName("joke")
    var joke:String,
    var createdAt: String
        )