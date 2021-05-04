package com.carpet.goharshad.domain.baseusecases

import com.carpet.goharshad.domain.utils.readServerError
import com.carpet.goharshad.shared.resource.Resource
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * Executes business logic synchronously or asynchronously using Coroutines.
 *
 * The [execute] method of [SuspendUseCase] is a suspend function as opposed to the
 * [SuspendUseCase.execute] method of [UseCase].
 */
abstract class SuspendUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /** Executes the use case asynchronously and returns a [Resource].
     *
     * @return a [Resource].
     *
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): Resource<R> {
        return try {
            // Moving all use case's executions to the injected dispatcher
            // In production code, this is usually the Default dispatcher (background thread)
            // In tests, this becomes a TestCoroutineDispatcher
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Resource.Success(it)
                }
            }
        } catch (e: CancellationException) {
            Resource.Canceled
        } catch (e: HttpException) {
            val parsedError = try {
                readServerError(e)
            } catch (e: Exception) {
                Exception(e)
            }
            Resource.Error(parsedError)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}
