package com.example.fruitsshopapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.media.Image
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitsshopapp.databinding.CategoriesItemBinding

class CategoriesAdapter(
    private val callBack: CallBack,
    private val categoriesList: List<Categories>
)
    : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imvCategoriesPictures)
        val name = view.findViewById<TextView>(R.id.tvCategoriesName)
    }

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(view.context).inflate(R.layout.categories_item, view, false)
        return ViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categoriesList[position]

        holder.image.setImageResource(item.image)
        holder.image.backgroundTintList = ColorStateList.valueOf(item.backgroundColor.toColorInt())
        holder.name.text = item.name

        holder.itemView.setOnClickListener {
            callBack.onCategoriesClick(item)
        }
    }

    interface CallBack {
        fun onCategoriesClick(item: Categories)
    }
}
