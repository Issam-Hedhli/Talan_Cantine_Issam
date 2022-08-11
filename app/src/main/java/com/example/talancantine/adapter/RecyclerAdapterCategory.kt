package com.example.talancantine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.talancantine.R
import kotlinx.android.synthetic.main.list_items.view.*

class RecyclerAdapterCategory:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var titles= arrayListOf("PIZZA","BURGER","SANDWICH","DRINKS ")
    private var images= intArrayOf(R.drawable.pizza,R.drawable.burger,R.drawable.sandwich,R.drawable.drink)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle:TextView


        init {
            itemImage=itemView.findViewById(R.id.img_dish)
            itemTitle=itemView.findViewById(R.id.tv_dish_name)


        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.tv_dish_name).text=titles[position]
        holder.itemView.findViewById<ImageView>(R.id.img_dish).setImageResource(images[position])
    }

}