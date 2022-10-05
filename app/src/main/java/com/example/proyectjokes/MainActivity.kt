package com.example.proyectjokes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtBestJoke = findViewById<TextView>(R.id.txtBestJoke)
        var btJokes = findViewById<Button>(R.id.btJokes)

        btJokes.setOnClickListener {
            var intent = Intent(this,JokesActivity::class.java);
            startActivity(intent);
        }
    }
}