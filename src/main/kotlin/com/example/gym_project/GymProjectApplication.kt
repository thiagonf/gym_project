package com.example.gym_project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GymProjectApplication

fun main(args: Array<String>) {
	runApplication<GymProjectApplication>(*args)
}
