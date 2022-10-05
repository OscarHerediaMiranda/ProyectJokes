package com.example.proyectjokes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyectjokes.model.Joke

@Database(entities = arrayOf(Joke::class),version = 1)
class AppDatabase: RoomDatabase() {
    abstract fun getDao() : ContactDao

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            //Aqui pregunto si la BD no existe
            if (INSTANCE == null){ //Aqui solo entrara la 1ra vez
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "myuser2.db")
                    .allowMainThreadQueries()
                    .build()
            }

            //la lin 25 SIEMPRE se hara
            return INSTANCE as AppDatabase
        }
    }
}