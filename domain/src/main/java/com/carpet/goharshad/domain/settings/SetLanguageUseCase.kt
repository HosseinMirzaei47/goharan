package com.carpet.goharshad.domain.settings;

import com.carpet.goharshad.android.IoDispatcher
import com.carpet.goharshad.data.repositories.settings.SettingsRepository
import com.carpet.goharshad.domain.baseusecases.SuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SetLanguageUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<Int, Unit>(dispatcher) {
    override suspend fun execute(parameters: Int) = settingsRepository.setLanguage(parameters)
}
