package com.keling.app.data.network

import com.google.gson.annotations.SerializedName

// Request Models
data class QwenRequest(
    val model: String = "qwen-turbo",
    val input: Input,
    val parameters: Parameters = Parameters()
) {
    data class Input(
        val messages: List<Message>
    )

    data class Message(
        val role: String,
        val content: String
    )

    data class Parameters(
        @SerializedName("result_format")
        val resultFormat: String = "message"
    )
}

// Response Models
data class QwenResponse(
    val output: Output?,
    val usage: Usage?,
    @SerializedName("request_id")
    val requestId: String?,
    val code: String?,
    val message: String?
) {
    data class Output(
        val choices: List<Choice>?
    )

    data class Choice(
        val message: QwenRequest.Message,
        @SerializedName("finish_reason")
        val finishReason: String?
    )

    data class Usage(
        @SerializedName("total_tokens")
        val totalTokens: Int?,
        @SerializedName("input_tokens")
        val inputTokens: Int?,
        @SerializedName("output_tokens")
        val outputTokens: Int?
    )
}

// Error Response Model
data class QwenErrorResponse(
    val code: String?,
    val message: String?,
    @SerializedName("request_id")
    val requestId: String?
)
