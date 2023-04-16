package com.example.fruitsshopapp

import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable.Orientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fruitsshopapp.CategoriesAdapter.CallBack
import com.example.fruitsshopapp.databinding.ActivityHomeBinding

lateinit var homeBinding: ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        setRVLayoutManagerSpanCount(this.resources.configuration)

        homeBinding.imvHomeMenu.setOnClickListener {
            Toast.makeText(this, "Open Home Menu", Toast.LENGTH_SHORT).show()
        }

        homeBinding.imvShoppingCart.setOnClickListener {
            Toast.makeText(this, "Open Shopping Cart", Toast.LENGTH_SHORT).show()
        }

        homeBinding.imvSearchClick.setOnClickListener {
            Toast.makeText(this, "Searching", Toast.LENGTH_SHORT).show()
        }

        val categoriesList: List<Categories> = DataSource().loadCategoriesData()
        val callBack = object : CallBack {
            override fun onCategoriesClick(item: Categories) {
                val intent = Intent(this@HomeActivity, ListProductActivity::class.java)
                intent.putExtra("name", item.name)
                startActivity(intent)
            }

        }
        homeBinding.rvCategories.adapter = CategoriesAdapter(callBack, categoriesList)

        homeBinding.tvSeeAll.setOnClickListener {
            val intent = Intent(this, ListProductActivity::class.java)
            intent.putExtra("name", "Categories")
            startActivity(intent)
        }

        val listTopProduct = DataSource().loadVegetablesProductData()
        var topProductCallBack = object : TopProductAdapter.CallBack {
            override fun topProductItemClick(item: Product) {
                val intent = Intent(this@HomeActivity, ProductDetailsActivity::class.java)
                intent.putExtra("product", item)
                startActivity(intent)
            }

            override fun topProductLikeClick(item: Product) {
                Toast.makeText(this@HomeActivity, "Liked ${item.name}", Toast.LENGTH_SHORT).show()
            }

        }

        homeBinding.rvTopProducts.adapter = TopProductAdapter(topProductCallBack, listTopProduct)

        homeBinding.imvNavBarHome.setOnClickListener {
            Toast.makeText(this, "Tab Home", Toast.LENGTH_SHORT).show()
        }
        homeBinding.imvNavBarLike.setOnClickListener {
            Toast.makeText(this, "Tab Like", Toast.LENGTH_SHORT).show()
        }
        homeBinding.imvNavBarNotif.setOnClickListener {
            Toast.makeText(this, "Tab Notif", Toast.LENGTH_SHORT).show()
        }
        homeBinding.imvNavBarUser.setOnClickListener {
            Toast.makeText(this, "Tab User", Toast.LENGTH_SHORT).show()
        }

    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setRVLayoutManagerSpanCount(newConfig)
    }

    fun setRVLayoutManagerSpanCount(newConfig: Configuration) {
        val dpWidth: Int = newConfig.screenWidthDp
        val topProductItemWidth = 166
        var spanCountGrid = dpWidth / topProductItemWidth
        if (spanCountGrid < 1){ spanCountGrid = 1 }

        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            val newLayoutManager = GridLayoutManager(this, spanCountGrid)
            homeBinding.rvTopProducts.layoutManager = newLayoutManager
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            val newLayoutManager = GridLayoutManager(this, spanCountGrid)
            homeBinding.rvTopProducts.layoutManager = newLayoutManager
        }
    }
}