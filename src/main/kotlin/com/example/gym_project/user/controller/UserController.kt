package com.example.gym_project.user.controller

import com.example.gym_project.user.model.User

class UserController {
    var listUser: MutableList<User> =  mutableListOf<User>()
    fun create(user : User): User{
        listUser.add(user)
        return user
    }

    fun listById(id: Short): List<User> {
        val filterUsers: List<User> = listUser.filter { user -> user.id == id }
        if(filterUsers.isNotEmpty()){
            return filterUsers
        } else{
            throw NoSuchElementException("User id $id not found!")
        }

    }

    fun listAll(): List<User> {
        return listUser
    }
}