package com.example.fruitsshopapp

class DataSource {
    fun loadCategoriesData(): List<Categories> {
        return listOf<Categories>(
            Categories(R.drawable.categories_fruits, "#0FA9B2A9", "Fruits"),
            Categories(R.drawable.categories_vegetables, "#EDFFDA", "Vegetables"),
            Categories(R.drawable.categories_drinks, "#3D8CAF35", "Drinks"),
            Categories(R.drawable.categories_bakery, "#69D6FFDA", "Bakery"),
            Categories(R.drawable.categories_bakery2, "#78FFFACC", "Bakery2"),
            Categories(R.drawable.categories_drinks, "#3D8CAF35", "Drinks"),
            Categories(R.drawable.categories_fruits, "#0FA9B2A9", "Fruits"),
            Categories(R.drawable.categories_bakery2, "#78FFFACC", "Bakery2")
        )
    }

    fun loadVegetablesProductData(): List<Product> {
        return listOf(
            Product("Tomato", "$1.50 / kg",R.drawable.product_tomato, "#1AFB9082", R.string.tomato_des),
            Product("Pummpkin", "$1.50 / kg", R.drawable.product_pumpkin, "#75FFF48F", R.string.pumpkin_des),
            Product("Brinjal", "$1.20 / kg", R.drawable.product_brinjal, "#EEE0F8", R.string.brinjal_des),
            Product("Cauliflower", "$1.50 / kg", R.drawable.product_cauliflower, "#EBF8EE", R.string.cauliflower_des),
            Product("Something1", "$1.50 / kg", R.drawable.product_something1, "#69FBD8E0", R.string.something1_des),
            Product("Something2", "$1.50 / kg", R.drawable.product_something2, "#36BCFEBF", R.string.something2_des)
        )
    }
}