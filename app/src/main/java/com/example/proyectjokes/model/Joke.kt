package com.example.proyectjokes.model

import com.google.gson.annotations.SerializedName

class Joke (
    @SerializedName("joke")
    var id: String,
    var source: String,
    var jokeId: String,
    var calificacion: Int,
    var joke:String,
    var createdAt: String
        )