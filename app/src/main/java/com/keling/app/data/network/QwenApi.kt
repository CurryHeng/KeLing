package com.keling.app.data.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface QwenApi {
    @POST("services/aigc/text-generation/generation")
    suspend fun chat(
        @Header("Authorization") apiKey: String,
        @Body request: QwenRequest
    ): Response<QwenResponse>
}
