package com.geeks.domain.usecases

import com.geeks.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    operator fun invoke(idToken: String, onSuccess: () -> Unit, onError: () -> Unit) =
        authRepository.auth(idToken, onSuccess, onError)
}