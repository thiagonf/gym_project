package com.example.gym_project.user.repo

import com.example.gym_project.user.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository



@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findById(id: Int): List<User>
}