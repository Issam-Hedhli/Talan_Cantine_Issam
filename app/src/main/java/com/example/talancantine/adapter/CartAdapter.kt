package com.example.talancantine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.talancantine.R

class CartAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var titles= arrayListOf("PIZZA","BURGER","PIZZA")
    private var images= intArrayOf(R.drawable.pop_1, R.drawable.pop_2, R.drawable.pop_3)
    private var numbersItem= arrayListOf("1","3","2")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_cart,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_Title_cart).text=titles[position]
        holder.itemView.findViewById<ImageView>(R.id.iv_item_cart).setImageResource(images[position])
        holder.itemView.findViewById<TextView>(R.id.numberItemtxt).text=numbersItem[position]

    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemNumber:TextView


        init {
            itemImage=itemView.findViewById(R.id.iv_item_cart)
            itemTitle=itemView.findViewById(R.id.tv_Title_cart)
            itemNumber=itemView.findViewById(R.id.numberItemtxt)


        }
    }

}