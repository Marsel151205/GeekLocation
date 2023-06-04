package com.geeks.domain.usecases

import com.geeks.domain.repositories.SaveUserDataRepository
import javax.inject.Inject

class SaveUserDataUseCase @Inject constructor(
    private val saveUserDataRepository: SaveUserDataRepository
) {

    operator fun invoke(name: String) =
        saveUserDataRepository.saveUserData(name)
}