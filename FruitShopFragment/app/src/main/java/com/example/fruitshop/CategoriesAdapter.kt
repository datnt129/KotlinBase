package com.example.fruitshop

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(
    private val dataset: List<Categories>,
    private val callBack: CallBack
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.item_categories_image)
        val name = view.findViewById<TextView>(R.id.item_categories_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.image.setImageResource(item.image)
        holder.image.setBackgroundColor(item.color.toColorInt())
        holder.name.text = item.name

        holder.itemView.setOnClickListener {
            callBack.onClick(item)
        }
    }

    interface CallBack {
        fun onClick(item: Categories)
    }
}