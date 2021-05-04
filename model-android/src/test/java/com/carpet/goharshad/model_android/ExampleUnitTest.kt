package com.carpet.goharshad.model_android

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        val names = flowOf(listOf("hossein", "mamad"))

        runBlocking {
            val mapped = names.map { list ->
                list.map {
                    it.length
                }
            }
        }
    }
}