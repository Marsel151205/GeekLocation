package com.geeks.presentation.ui.fragments.auth

import androidx.lifecycle.ViewModel
import com.geeks.domain.usecases.AuthUseCase
import com.geeks.domain.usecases.SaveUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val saveUserDataUseCase: SaveUserDataUseCase
) : ViewModel() {

    fun auth(idToken: String, onSuccess: () -> Unit, onError: () -> Unit) =
        authUseCase(idToken, onSuccess, onError)

    fun saveUserData(name: String) = saveUserDataUseCase(name)
}