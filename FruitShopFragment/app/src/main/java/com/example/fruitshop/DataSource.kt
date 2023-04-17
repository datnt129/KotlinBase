package com.example.fruitshop

class DataSource {
    fun Categories(): List<Categories> {
        return listOf<Categories>(
            Categories("Fruits", R.drawable.categories_fruits, "#0FA9B2A9"),
            Categories("Vegetable", R.drawable.categories_fruits, "#B5E9FFD2"),
            Categories("Drinks", R.drawable.categories_fruits, "#3D8CAF35"),
        )
    }
}