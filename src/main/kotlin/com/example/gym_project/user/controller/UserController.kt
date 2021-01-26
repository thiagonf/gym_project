package com.example.gym_project.user.controller

import com.example.gym_project.user.model.User

class UserController {
    var listUser: MutableList<User> =  mutableListOf<User>()
    fun create(user : User){
        listUser.add(user)
    }
}