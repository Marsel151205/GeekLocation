package com.geeks.domain.repositories

interface AuthRepository {

    fun auth(idToken: String, onSuccess: () -> Unit, onError: () -> Unit)
}