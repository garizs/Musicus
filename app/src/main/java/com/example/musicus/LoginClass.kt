package com.example.musicus

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class loginClass(login: String, password: String){
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
    suspend fun loginFun(): Response {
        var response: Response = Response(null)
        try{
            response = client.get("https://sandbox.api.service.nhs.uk/hello-world/hello/world").body()
        }catch (e : Exception){
            e.printStackTrace()
        }
        return response
    }
}