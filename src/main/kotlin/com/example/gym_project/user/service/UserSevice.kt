package com.example.gym_project.user.service

import com.example.gym_project.user.controller.UserController
import com.example.gym_project.user.model.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserService {
    val controller = UserController()

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User): User {
        return controller.create(user)
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    fun listUser(): List<User> {
        return controller.listAll()
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun listUserById(@PathVariable id: Short): List<User> {
        return controller.listById(id)
    }

}