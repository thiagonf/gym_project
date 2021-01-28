package com.example.gym_project.user.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertThrows
import java.lang.IllegalArgumentException


class UserTest {
    @Test
    fun `Test create User`(){
        val id = 1.toShort()
        val name = "Thiago"
        val email = "thiago@test.com"
        val phone = "9999-9999"
        val user = User(id, name, email ,phone)

        Assertions.assertTrue(user.id == id)
        Assertions.assertTrue(user.name == name)
        Assertions.assertTrue(user.email == email)
        Assertions.assertTrue(user.phone == phone)
    }

    @Test
    fun `Test validation email User`(){
        val id = 1.toShort()
        val name = "Thiago"
        val email = "thiago123"
        val phone = "9999-9999"

        assertThrows<IllegalArgumentException> { User(id, name, email ,phone)  }

    }
}