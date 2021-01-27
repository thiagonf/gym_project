package com.example.gym_project.user.controller

import com.example.gym_project.exception.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class UserException {
    private val errorResponse = ErrorResponse()

    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgumentException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse>  {
        return errorResponse.generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.message.toString(), exception)
    }
}