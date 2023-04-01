package com.example.fruitsshopapp

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import com.example.fruitsshopapp.databinding.ActivityProductDetailsBinding


lateinit var productDetailsBinding: ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productDetailsBinding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(productDetailsBinding.root)

        val product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("product", Product::class.java)!!
        } else {
            intent.getParcelableExtra<Product>("product")!!
        }

        val listRelatedItem = DataSource().loadVegetablesProductData()
        var callBack = object: RelatedItemsAdapter.CallBack {
            override fun itemClick(item: Product) {
                val intent = Intent(this@ProductDetailsActivity, ProductDetailsActivity::class.java)
                intent.putExtra("product", item)
                startActivity(intent)
            }

        }
        productDetailsBinding.rvRelatedItem.adapter = RelatedItemsAdapter(callBack, listRelatedItem)

        productDetailsBinding.imvPDImage.setImageResource(product.image)
        productDetailsBinding.tvPDname.text = product.name
        productDetailsBinding.tvPDPrice.text = product.price
        productDetailsBinding.tvPDdes.text = this.getString(product.des)
        productDetailsBinding.imvPDImage.setBackgroundColor(product.backgroundColor.toColorInt())


        val pdName = productDetailsBinding.tvPDname
        val pdCount = productDetailsBinding.tvPDCount
        val maxCount = 10

        productDetailsBinding.imvPDBack.setOnClickListener {
            this.finish()
        }

        productDetailsBinding.btnAddToCart.setOnClickListener {
            Toast.makeText(this, "adding $pdCount of $pdName", Toast.LENGTH_SHORT).show()
        }

        productDetailsBinding.tvAddPD.setOnClickListener {
            val curentCount = pdCount.text.toString().toInt()
            if (curentCount >= maxCount) return@setOnClickListener
            pdCount.text = (curentCount + 1).toString()
        }

        productDetailsBinding.tvMinusPD.setOnClickListener {
            val curentCount = pdCount.text.toString().toInt()
            if (curentCount <= 1) return@setOnClickListener
            pdCount.text = (curentCount - 1).toString()
        }
    }
}