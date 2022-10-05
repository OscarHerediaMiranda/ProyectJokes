package com.example.proyectjokes.database

import androidx.room.*

import com.example.proyectjokes.model.Joke

@Dao()
interface JokeDao {
    @Query("SELECT * FROM Joke")
    fun getAll(): List<Joke>

    @Insert
    fun insertContact(vararg contacts: Joke)

    @Delete
    fun deleteContact(vararg contacts: Joke)

    @Update
    fun updateContact(vararg contacts: Joke)
}