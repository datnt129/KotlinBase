package com.example.fruitsshopapp

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView

class RelatedItemsAdapter(
    private var callBack: CallBack,
    private var listItem: List<Product>
) : RecyclerView.Adapter<RelatedItemsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imvRelatedImage)
        val name = view.findViewById<TextView>(R.id.tvRelatedName)
        val price = view.findViewById<TextView>(R.id.tvRelatedPrice)
    }

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(view.context).inflate(R.layout.related_item, view, false)
        return ViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.price.text = item.price.split(" / ")[0]
        holder.image.backgroundTintList = ColorStateList.valueOf(item.backgroundColor.toColorInt())
        holder.itemView.setOnClickListener {
            callBack.itemClick(item)
        }
    }

    interface CallBack {
        fun itemClick(item: Product)
    }
}