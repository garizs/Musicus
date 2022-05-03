package com.example.musicus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userField = findViewById<EditText>(R.id.emailTextInput)
        val passwordField = findViewById<EditText>(R.id.passwordTextInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener{
            val email = userField.text.toString()
            val password = passwordField.text.toString()
            mainScope.launch {
                kotlin.runCatching {
                    loginClass(email, password).loginFun()
                }.onSuccess {
                    userField.setText(it.message)
                }.onFailure {
                    userField.setText("Error: ${it.localizedMessage}")
                }
            }
        }
    }
}
