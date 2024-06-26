package com.example.lab3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.lab3data.Producto

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "restaurante.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "productos"
        private const val COL_ID = "id"
        private const val COL_NOMBRE = "nombre"
        private const val COL_DESCRIPCION = "descripcion"
        private const val COL_PRECIO = "precio"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // ... (createTable code as before)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // ... (onUpgrade code as before)
    }

    // CRUD Operations:

    fun addProducto(producto: Producto): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ID, producto.id)
        contentValues.put(COL_NOMBRE, producto.nombre)
        contentValues.put(COL_DESCRIPCION, producto.descripcion)
        contentValues.put(COL_PRECIO, producto.precio)
        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return success
    }

    fun updateProducto(producto: Producto): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ID, producto.id)
        contentValues.put(COL_NOMBRE, producto.nombre)
        contentValues.put(COL_DESCRIPCION, producto.descripcion)
        contentValues.put(COL_PRECIO, producto.precio)

        val success = db.update(TABLE_NAME, contentValues, "$COL_ID=?", arrayOf(producto.id.toString()))
        db.close()
        return success
    }

    fun deleteProducto(producto: Producto): Int {
        val db = this.writableDatabase
        val success = db.delete(TABLE_NAME, "$COL_ID=?", arrayOf(producto.id.toString()))
        db.close()
        return success
    }
}