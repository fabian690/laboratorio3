package com.example.lab3data

data class Producto(
    var id: Int? = null,
    var nombre: String? = null,
    var descripcion: String? = null,
    var precio: Double? = null,
    var imagen: String? = null
)

 {
    // Secondary constructor without delegation
    constructor(id: Int, nombre: String, descripcion: String, precio: Double,imagen : String ) : this() {
        this.id = id
        this.nombre = nombre
        this.descripcion = descripcion
        this.precio = precio
        this.imagen = imagen

    }
}