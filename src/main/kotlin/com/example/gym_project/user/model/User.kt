package com.example.gym_project.user.model

data class User(
    val id: Short,
    var name: String,
    var email: String,
    var phone: String){
    init {
        if (email.isEmpty() || !email.matches(Regex("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[a-zA-Z]{2,})$"))) {
            throw IllegalArgumentException("$email is not a valid email address")
        }
    }
}