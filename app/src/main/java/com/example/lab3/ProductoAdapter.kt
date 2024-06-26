package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3data.Producto


import android.content.Context
import android.widget.ImageView

import com.bumptech.glide.Glide

class ProductoAdapter(ctx: Context,private val productosList: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {



    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // val idTextView: TextView = itemView.findViewById(R.id.idTextView)
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionTextView)
       // val precioTextView: TextView = itemView.findViewById(R.id.precioTextView)
        val imageUrl: ImageView = itemView.findViewById(R.id.imagenTextView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(itemView)
    }

   /* override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val currentItem = productosList[position]
        holder.nombreTextView.text = currentItem.nombre
        holder.descripcionTextView.text = currentItem.descripcion
        holder.precioTextView.text = "$${currentItem.precio}"
        holder.imagenTextView.text = currentItem.imagen

    }*/

    override fun getItemCount() = productosList.size


    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val i = productosList[position]
        holder.nombreTextView.text = i.nombre
        holder.descripcionTextView.text = i.descripcion
        Glide.with(holder.itemView.context)
            .load(i.imagen
                ,)
            .centerCrop()
//.placeholder(R.drawable.loading_spinner)
            .into(holder.imageUrl)
    }

}