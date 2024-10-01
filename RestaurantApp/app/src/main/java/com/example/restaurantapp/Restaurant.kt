package com.example.restaurantapp

data class Restaurant (val id: Int,
                       val title: String,
                       val description: String)

val dummyRestaurants = listOf(
    Restaurant(0, "Alfredo foods", "At Alfredo's ..."),
    Restaurant(1, "Mike and Ben's food pub", "desripton") ,
    Restaurant(2, "Alfredo foods", "At Alfredo's ..."),
    Restaurant(3, "Mike and Ben's food pub", "desripton"),
    Restaurant(0, "Alfredo foods", "At Alfredo's ..."),
    Restaurant(1, "Mike and Ben's food pub", "desripton") ,
    Restaurant(2, "Alfredo foods", "At Alfredo's ..."),
    Restaurant(3, "Mike and Ben's food pub", "desripton"),
    Restaurant(0, "Alfredo foods", "At Alfredo's ..."),
    Restaurant(1, "Mike and Ben's food pub", "desripton") ,
    Restaurant(2, "Alfredo foods", "At Alfredo's ..."),
    Restaurant(3, "Mike and Ben's food pub", "desripton")
)
