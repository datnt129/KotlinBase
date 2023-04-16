package com.example.fruitsshopapp

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitsshopapp.databinding.ProductItemBinding

lateinit var productItemBinding: ProductItemBinding

class ListProductsAdapter(
    private val callback: CallBack,
    private val listProducts: List<Product>
) :RecyclerView.Adapter<ListProductsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.tvProductName)
        val image = view.findViewById<ImageView>(R.id.imvProductImage)
        val price = view.findViewById<TextView>(R.id.tvProductPrice)
        val container = view.findViewById<TextView>(R.id.tvBackgroundProduct)
        val like = view.findViewById<ImageView>(R.id.imvProductLikeButton)
        val product = view.findViewById<ConstraintLayout>(R.id.clContainerProductItem)
    }

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(view.context).inflate(R.layout.product_item, view, false )
        return ViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listProducts[position]
        holder.name.text = item.name
        holder.price.text = item.price.split(" / ")[0]
        holder.image.setImageResource(item.image)
        holder.container.backgroundTintList = ColorStateList.valueOf(item.backgroundColor.toColorInt())
        holder.product.setOnClickListener {
            callback.productItemClick(item)
        }
        holder.like.setOnClickListener {
            callback.productLikeClick(item)
        }
    }

    interface CallBack {
        fun productItemClick(item: Product)
        fun productLikeClick(item: Product)
    }
}