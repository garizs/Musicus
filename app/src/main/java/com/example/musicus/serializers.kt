package com.example.musicus
import kotlinx.serialization.*

@Serializable
data class Response(
    @SerialName("message")
    var message: String?
)