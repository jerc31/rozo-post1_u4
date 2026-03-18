package com.jhoseth_rozo.taskmanager.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Versión 1 del esquema — sin campo priority
@Entity(tableName = "tasks")
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val description: String,

    val isCompleted: Boolean = false,

    val createdAt: Long = System.currentTimeMillis()
)