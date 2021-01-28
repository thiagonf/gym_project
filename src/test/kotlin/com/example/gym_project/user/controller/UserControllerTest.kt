package com.example.gym_project.user.controller

import com.example.gym_project.user.model.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserControllerTest {
    @Test
    fun `Test create instance UserController`(){
        val userController = UserController()

        Assertions.assertTrue(userController.listUser.size == 0)
    }

    @Test
    fun `Test list of users`(){
        val userController = UserController()
        val user = User(id = 1, name= "Thiago", email = "thiago@test.com", phone = "9999-9999")

        userController.create(user)
        val listUsers = userController.listUser

        Assertions.assertTrue(listUsers.size == 1)
        Assertions.assertTrue(listUsers.get(index = 0).id == user.id)
        Assertions.assertTrue(listUsers.get(index = 0).name == user.name)
        Assertions.assertTrue(listUsers.get(index = 0).email == user.email)
        Assertions.assertTrue(listUsers.get(index = 0).phone == user.phone)
    }
}