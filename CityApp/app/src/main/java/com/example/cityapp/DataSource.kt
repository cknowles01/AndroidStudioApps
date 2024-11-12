package com.example.cityapp

data class Place(
    val id: String,
    val category: String,
    val name: String,
    val details: String
)

data class Category(
    val name: String,
    val places: List<Place>
)

object DataSource {
    val places = listOf(
        Category(
            "Restaurant",
            listOf(
                Place("1", "Restaurants", "Tamarack", "details..."),
                Place("1", "Restaurants", "Place", "deets..."),
            )
        ),
        Category(
            "Park",
            listOf(
                Place("2", "Parks", "Caras Park", "deets.."),
                Place("2", "Parks", "Missoula Park", "deets."),
            )
        ),
        Category(
            "Store",
            listOf(
                Place("3", "Stores", "Scheels", "deets"),
                Place("3", "Stores", "Scheels", "deets") ,
            )
        )
    )





}


