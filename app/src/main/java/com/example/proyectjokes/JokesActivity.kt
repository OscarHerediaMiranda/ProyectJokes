package com.example.proyectjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.proyectjokes.model.Joke
import com.example.proyectjokes.services.JokeService
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.math.log

class JokesActivity : AppCompatActivity() {
    lateinit var txtJoke: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)
        txtJoke = findViewById<TextView>(R.id.txtJoke)

        var bt1 = findViewById<Button>(R.id.bt1)

        bt1.setOnClickListener {
           saveData(1)
        }

        var bt2 = findViewById<Button>(R.id.bt2)
        bt2.setOnClickListener {
            saveData(2)
        }

        var bt3 = findViewById<Button>(R.id.bt3)
        bt3.setOnClickListener {
            saveData(3)
        }

        var bt4 = findViewById<Button>(R.id.bt4)
        bt4.setOnClickListener {
            saveData(4)
        }

        var bt5 = findViewById<Button>(R.id.bt5)
        bt5.setOnClickListener {
            saveData(5)
        }

        loadJoke()
    }

    fun loadJoke(){

        //1. crear la instancia del retrofit
        var retrofit = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //2. inyectar el servicio creado a la instancia retrofit
        var jokeService:JokeService
        jokeService = retrofit.create(JokeService::class.java)

        //3. llamar a la funcion getJoke() (aqui se arma el request)
        var request = jokeService.getJoke("json")

        //4. se va a acceder a la respuesta del api (se recibe el response)
        request.enqueue(object : Callback<Joke>{
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if(response.isSuccessful){
                    Log.e("RESPONSE","${response.body()}")
                    txtJoke.text = response.body()!!.joke;
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.e("RESPONSE","HUBO UN ERROR")
            }
        })
    }

    fun saveData(calificacion: Int){
        var jokesave = Joke(UUID.randomUUID().toString(),"","",calificacion ,txtJoke.text.toString(),"5/10/2022");
        Log.e("JOKESAVE","${jokesave}")
    }
}