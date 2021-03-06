package com.carpet.goharshad.domain.baseusecases

import com.part.livetaskcore.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * Executes business logic in its execute method and keep posting updates to the Resource as
 * [Resource<R>].
 * Handling an exception (emit [Resource.Error] to the Resource) is the subclasses's responsibility.
 */
abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    operator fun invoke(parameters: P): Flow<Resource<R>> = execute(parameters)
        .catch { e -> emit(Resource.Error(Exception(e))) }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<Resource<R>>
}