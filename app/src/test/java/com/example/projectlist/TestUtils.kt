package com.example.projectlist

import org.mockito.Mockito
import kotlin.random.Random

object TestUtils {

    fun <T> anyObject(): T {
        Mockito.anyObject<T>()
        return uninitialized()
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> uninitialized(): T = null as T

    fun generateHex(): String {
        val zeros = "000000"
        val randomString = Random(10).nextInt(0, 16).toString()
        return zeros.substring(randomString.length) + randomString
    }

}