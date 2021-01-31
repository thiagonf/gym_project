package com.example.gym_project.user.controller

import com.example.gym_project.user.model.User
import com.example.gym_project.user.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController(){
    @Autowired
    private lateinit var repository: UserRepository

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User): User {
        user.validate(user)
        return repository.save(user)
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    fun listUser(): MutableIterable<User> {
        return repository.findAll()
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun listUserById(@PathVariable id: Int): Iterable<User> {
        return repository.findById(id)
    }
}