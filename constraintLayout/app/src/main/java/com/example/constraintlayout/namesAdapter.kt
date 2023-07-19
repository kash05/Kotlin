package com.example.constraintlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class namesAdapter:RecyclerView.Adapter<namesAdapter.NamesViewHolder>() {

    var namess = arrayOf<nameData>()
    set (value){
        field = value
        notifyDataSetChanged()
    }

    class NamesViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val personImage = view.findViewById<ImageView>(R.id.image)
        val personName = view.findViewById<TextView>(R.id.name)
        val personAge = view.findViewById<TextView>(R.id.age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.iitem,parent,false)
        return NamesViewHolder(itemLayout)
    }

    override fun getItemCount() = namess.size

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        with(holder){
                personImage.setImageResource(namess[position].flagId)
                personName.text = namess[position].name
                personAge.text = namess[position].age.toString()
        }

    }

    override fun getItemId(position: Int): Long {
        return namess[position].hashCode().toLong()
    }
}

