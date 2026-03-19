package com.universidad.taskmanager

import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.universidad.taskmanager.data.local.AppDatabase
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class MigrationTest {
    private val TEST_DB = "migration-test"

    @get:Rule
    val helper: MigrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        AppDatabase::class.java
    )

    @Test
    @Throws(IOException::class)
    fun migrate1To2() {
        // Creamos la base de datos en la versión 1
        var db = helper.createDatabase(TEST_DB, 1)

        // Insertamos datos en la v1 (sin el campo priority)
        // Nota: createdAt se genera en el objeto, pero aquí insertamos directo por SQL
        db.execSQL("INSERT INTO tasks (title, description, isCompleted, createdAt) VALUES ('Tarea Test', 'Desc', 0, ${System.currentTimeMillis()})")
        db.close()

        // Migramos a la versión 2
        db = helper.runMigrationsAndValidate(TEST_DB, 2, true, AppDatabase.MIGRATION_1_2)

        // Verificamos que los datos persisten y el nuevo campo existe con el valor por defecto
        val cursor = db.query("SELECT * FROM tasks")
        assert(cursor.moveToFirst())
        val priorityIndex = cursor.getColumnIndex("priority")
        assert(priorityIndex != -1)
        assertEquals(1, cursor.getInt(priorityIndex))
        cursor.close()
    }
}
