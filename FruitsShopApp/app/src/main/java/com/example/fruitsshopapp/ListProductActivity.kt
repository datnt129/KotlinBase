package com.example.fruitsshopapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fruitsshopapp.databinding.ActivityListProductBinding

lateinit var listProductBinding: ActivityListProductBinding

class ListProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listProductBinding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(listProductBinding.root)
        setRVLayoutManagerSpanCount(this.resources.configuration)

        listProductBinding.tvCategoriesText.text = intent.getStringExtra("name")

        listProductBinding.imvBack.setOnClickListener {
            this.finish()
        }

        listProductBinding.imvShoppingCart.setOnClickListener {
            Toast.makeText(this, "Open Shopping Cart", Toast.LENGTH_SHORT).show()
        }

        val listProduct = DataSource().loadVegetablesProductData()
        var callBack = object: ListProductsAdapter.CallBack {
            override fun productItemClick(item: Product) {
                val intent = Intent(this@ListProductActivity, ProductDetailsActivity::class.java)
                intent.putExtra("product", item)
                startActivity(intent)
            }

            override fun productLikeClick(item: Product) {
                Toast.makeText(this@ListProductActivity, "add ${item.name} to Liked List", Toast.LENGTH_SHORT).show()
            }

        }

        listProductBinding.rvListProducts.adapter = ListProductsAdapter(callBack, listProduct)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setRVLayoutManagerSpanCount(newConfig)
    }

    fun setRVLayoutManagerSpanCount(newConfig: Configuration) {
        val dpWidth: Int = newConfig.screenWidthDp
        val topProductItemWidth = 167
        var spanCountGrid = dpWidth / topProductItemWidth
        if (spanCountGrid < 1){ spanCountGrid = 1 }

        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            val newLayoutManager = GridLayoutManager(this, spanCountGrid)
            listProductBinding.rvListProducts.layoutManager = newLayoutManager
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            val newLayoutManager = GridLayoutManager(this, spanCountGrid)
            listProductBinding.rvListProducts.layoutManager = newLayoutManager
        }
    }
}