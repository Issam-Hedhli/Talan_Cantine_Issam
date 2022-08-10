package com.example.talancantine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.talancantine.R
import kotlinx.android.synthetic.main.list_items.view.*

class RecyclerAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var titles= arrayListOf("HAMBURGER","HAMBURGER","HAMBURGER","HAMBURGER")
    private var images= intArrayOf(R.drawable.food1,R.drawable.food1,R.drawable.food1,R.drawable.food1)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false)
        return ViewHolder(v)
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