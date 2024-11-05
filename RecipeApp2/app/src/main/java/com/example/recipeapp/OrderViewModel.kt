package com.example.recipeapp

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapp.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OrderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    private val _groceryList = MutableLiveData<MutableList<String>>()
    val groceryList: MutableLiveData<MutableList<String>> = _groceryList

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> = _recipes

    private val _selectedIngredients = mutableStateMapOf<String, Boolean>()


    private fun myRecipes() {
        _recipes.value = listOf(
            Recipe("Hamburger", R.drawable.burger, listOf("Beef", "Buns", "Cheese", "Lettuce")),
            Recipe("Pizza", R.drawable.pizza, listOf("Cheese", "Pepperoni", "Dough", "Tomato Sauce")),
            Recipe("Clam Chowder", R.drawable.clamchowder, listOf("Clams", "Potatoes", "Onions", "Cream", "Bacon"))

        )
    }

    fun addIngredientToGroceryList(ingredient: String) {
        _groceryList.value?.apply {
            if (!contains(ingredient)) {
                add(ingredient)
                _groceryList.value = this
            }
        }
    }

    fun removeIngredientFromGroceryList(ingredient: String) {
        _groceryList.value?.apply {
            remove(ingredient)
            _groceryList.value = this
        }
    }


    fun isIngredientSelected(ingredient: String): Boolean {
        return _selectedIngredients[ingredient] ?: false
    }


    fun toggleIngredient(ingredient: String, isChecked: Boolean) {
        if (isChecked) {
            addIngredientToGroceryList(ingredient)
            _selectedIngredients[ingredient] = true
        } else {
            removeIngredientFromGroceryList(ingredient)
            _selectedIngredients[ingredient] = false
        }
    }



    fun clearGroceryList() {
        _groceryList.value?.clear()
        _groceryList.value = _groceryList.value
    }
}


    data class Recipe(
        val name: String,
        val imageUrl: Int,
        val ingredients: List<String>
    )






