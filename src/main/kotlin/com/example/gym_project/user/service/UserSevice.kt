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
        controller.create(user)
        return user
    }

}