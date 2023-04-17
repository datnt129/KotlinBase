package com.example.demoretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(
    private val callback: CallBack,
    private val dataset: List<Album>
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView
        init {
            itemImage = view.findViewById(R.id.item_album_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        callback.onBack(item, holder.itemImage)

    }

    interface CallBack {
        fun onBack(item: Album, image: ImageView)
    }
}