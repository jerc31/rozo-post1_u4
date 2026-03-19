package com.universidad.taskmanager.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // ALTER TABLE agrega la columna con DEFAULT 1
        // SQLite exige DEFAULT o NULL en columnas nuevas
        database.execSQL(
            "ALTER TABLE tasks ADD COLUMN priority INTEGER NOT NULL DEFAULT 1"
        )
    }
}
