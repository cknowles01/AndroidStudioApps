package com.example.cityapp

data class Place(
    val id: String,
    val category: String,
    val name: String,
    val details: String
)

data class Category(
    val categoryName: String,
    val places: List<Place>
)

object DataSource {
    val places = listOf(
        Category(
            "Restaurants",
            listOf(
                Place("1", "Restaurants", "Tamarack", "Restaurant located downtown, known for its good food."),
                Place("1", "Restaurants", "McDonalds", "Famous fast-food restaurant, which has served over 100 billion burgers"),
                Place("1", "Restaurants", "Biga Pizza", "A famous pizza place which is located in Downtown Missoula")
            )
        ),
        Category(
            "Parks",
            listOf(
                Place("2", "Parks", "Caras Park", "Famous park in downtown Missoula, known for hosting events"),
                Place("2", "Parks", "Bonner Park", "Park that has a splash pad"),
            )
        ),
        Category(
            "Stores",
            listOf(
                Place("3", "Stores", "Scheels", "Sporting goods store located in the mall"),
                Place("3", "Stores", "Sportsmans Warehouse", "Sporting goods store located off of Mullan and Reserve"),
                Place("3", "Stores", "Rockin' Rudy's", "Famous Missoula store")
            )
        )
    )
}


