package com.carpet.goharshad.domain.settings

import com.carpet.goharshad.android.IoDispatcher
import com.carpet.goharshad.data.repositories.settings.SettingsRepository
import com.part.livetaskcore.usecases.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLanguageUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Int>(ioDispatcher) {
    override suspend fun execute(params: Unit): Flow<Int> = settingsRepository.getLanguage()
}