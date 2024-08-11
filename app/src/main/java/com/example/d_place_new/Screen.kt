package com.example.d_place_new

sealed class Screen (val route : String) {

    object Home : Screen("home")

    object SignIn : Screen("sign_in")
}