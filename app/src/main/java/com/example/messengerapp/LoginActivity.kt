package com.example.messengerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar: Toolbar = findViewById(R.id.toolbar_login)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Экран входа"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this@LoginActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        mAuth = FirebaseAuth.getInstance()

        login_button.setOnClickListener {
            loginUser9()
        }
    }

    private fun loginUser9() {
        val email: String = email_login.text.toString()
        val password: String = password_login.text.toString()

        if(email == "")
        {
            Toast.makeText(this@LoginActivity, "Введите email", Toast.LENGTH_LONG).show()
        }
        else if(password == "")
        {
            Toast.makeText(this@LoginActivity, "Введите пароль", Toast.LENGTH_LONG).show()
        }
        else
        {
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this@LoginActivity, "Ошибка:" + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}