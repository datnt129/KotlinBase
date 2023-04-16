package com.example.fruitsshopapp

import android.content.res.ColorStateList
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView

class TopProductAdapter(
    private val callBack: CallBack,
    private val listTopProduct: List<Product>
) : RecyclerView.Adapter<TopProductAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imvTopProductImage)
        val name = view.findViewById<TextView>(R.id.tvTopProductName)
        val price = view.findViewById<TextView>(R.id.tvTopProductPrice)
        val likeBtn = view.findViewById<ImageView>(R.id.imvTopProductLike)
        val background = view.findViewById<TextView>(R.id.tvTopProductbackground)
    }

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(view.context).inflate(R.layout.top_products_item, view, false)
        return ViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return listTopProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listTopProduct[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.price.text = item.price.split(" / ")[0]
        holder.background.backgroundTintList = ColorStateList.valueOf(item.backgroundColor.toColorInt())
        holder.price.backgroundTintList = ColorStateList.valueOf(item.backgroundColor.toColorInt())
        holder.likeBtn.backgroundTintList = ColorStateList.valueOf(item.backgroundColor.toColorInt())

        holder.likeBtn.setOnClickListener {
            callBack.topProductLikeClick(item)
        }
        holder.itemView.setOnClickListener {
            callBack.topProductItemClick(item)
        }
    }

    interface CallBack {
        fun topProductItemClick(item: Product)
        fun topProductLikeClick(item: Product)
    }
}