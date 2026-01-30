package com.keling.app.data.repository

import com.keling.app.BuildConfig
import com.keling.app.data.network.QwenApiClient
import com.keling.app.data.network.QwenRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QwenRepository @Inject constructor(
    private val qwenApiClient: QwenApiClient
) {
    private val apiKey = "Bearer ${BuildConfig.QWEN_API_KEY}"

    suspend fun chat(messages: List<QwenRequest.Message>): String {
        if (BuildConfig.QWEN_API_KEY.isBlank()) {
            return "Error: QWEN_API_KEY is empty"
        }
        return try {
            val request = QwenRequest(
                input = QwenRequest.Input(
                    messages = messages
                )
            )

            val response = qwenApiClient.api.chat(apiKey, request)
            if (response.isSuccessful) {
                response.body()?.output?.choices?.firstOrNull()?.message?.content ?: ""
            } else {
                "Error: ${response.code()} ${response.message()}"
            }
        } catch (e: Exception) {
            "Exception: ${e.message}"
        }
    }
}
