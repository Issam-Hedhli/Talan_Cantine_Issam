package com.example.talancantine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.talancantine.R

class RecyclerAdapterMenus(

):RecyclerView.Adapter<RecyclerAdapterMenus.MainViewHolder>() {

    private var titles= arrayListOf("STARTER","MAIN MENU","DESSERT","EXTRAS")
    private var images= intArrayOf(R.drawable.salade,R.drawable.pasta,R.drawable.dessert,R.drawable.sweets)
    private var prizes= arrayListOf("10 D","15 D","10 D","5 D")
    private var times = arrayListOf("15 minutes","20 minutes","10 minutes","10 minutes")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterMenus.MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_menus,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle:TextView
        var itemPrize:TextView
        var itemTime:TextView

        init {
            itemImage=itemView.findViewById(R.id.img_food_menu)
            itemTitle=itemView.findViewById(R.id.tv_title_menu)
            itemPrize=itemView.findViewById(R.id.tv_prize_menu)
            itemTime=itemView.findViewById(R.id.tv_time_menu)


        }
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {


        holder.itemView.findViewById<TextView>(R.id.tv_title_menu).text= titles[position]
        holder.itemView.findViewById<ImageView>(R.id.img_food_menu).setImageResource(images[position])
        holder.itemView.findViewById<TextView>(R.id.tv_prize_menu).text=prizes[position]
        holder.itemView.findViewById<TextView>(R.id.tv_time_menu).text=times[position]    }

}