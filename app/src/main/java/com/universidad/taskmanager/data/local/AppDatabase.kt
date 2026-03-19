package com.universidad.taskmanager.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TaskEntity::class],
    version = 2, // Versión 2 con soporte para migración
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "taskmanager.db"
                )
                    .addMigrations(MIGRATION_1_2) // Registro de la migración definida en Migrations.kt
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
