package com.example.gym_project.user.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int=0,
    var name: String="",
    @Column(unique = true, nullable = false)
    var email: String="",
    var phone: String=""){

    internal fun validate(user: User) {
        this.validateEmail(user)
    }

    private fun validateEmail(user: User){
        if (user.email.isEmpty() || !user.email.matches(Regex("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[a-zA-Z]{2,})$"))) {
            throw IllegalArgumentException("${user.email} is not a valid email address")
        }
    }
}