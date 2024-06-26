package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3data.Producto
import com.example.lab3.DatabaseHelper


class MainActivity : AppCompatActivity() {
    private lateinit var databaseHelper: DatabaseHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val r = findViewById<RecyclerView>(R.id.recycler1)

        val productoList = mutableListOf<Producto>(
            Producto(111,"Coca Cola","Deliciosa de 2 litro"
                ,12.3,"https://d10nbigpolte6j.cloudfront.net/media/catalog/product/c/o/coca_cola_2_l.jpg"
            ),
            Producto( 222,"Pritty Limon","De 1 litro"
            ,12.34,"https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/3080445_f.jpg"
        ),
            Producto(  333,"blue label","muy rica de 1 litro"
        ,12.4,"https://th.bing.com/th/id/R.c2ba8f2c25fdd45ba6677d7b261824fa?rik=t43shv1fymEiuw&pid=ImgRaw&r=0"
        ),
                )
        val productoAdapter = ProductoAdapter(applicationContext,productoList)
        r.adapter = productoAdapter
        val layout = LinearLayoutManager(applicationContext)
        layout.orientation = LinearLayoutManager.VERTICAL
        r.layoutManager = layout



    }



}
