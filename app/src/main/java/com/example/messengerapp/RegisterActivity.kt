package com.example.messengerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var mAuth:FirebaseAuth
    private lateinit var refUsers: DatabaseReference
    private var firebaseUserID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val toolbar : Toolbar = findViewById(R.id.toolbar_register)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Регистрация"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this@RegisterActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()

        }

        mAuth = FirebaseAuth.getInstance()

        register_button.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser() {
        val username: String = username_register.text.toString()
        val email: String = email_register.text.toString()
        val password: String = password_register.text.toString()

        if(username == "")
        {
            Toast.makeText(this@RegisterActivity, "Введите имя", Toast.LENGTH_LONG).show()
        }
        else if(email == "")
        {
            Toast.makeText(this@RegisterActivity, "Введите email", Toast.LENGTH_LONG).show()
        }
        else if(password == "")
        {
            Toast.makeText(this@RegisterActivity, "Введите пароль", Toast.LENGTH_LONG).show()
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    task ->
                    if (task.isSuccessful)
                    {
                        firebaseUserID = mAuth.currentUser!!.uid
                        refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserID)

                        val userHashMap = HashMap<String, Any>()
                        userHashMap["uid"] = firebaseUserID
                        userHashMap["email"] = email
                        userHashMap["username"] = username
                        userHashMap["profile"] = "https://firebasestorage.googleapis.com/v0/b/messengerapp-68b25.appspot.com/o/icon.png?alt=media&token=0d5a85df-239a-4b6f-98c3-2c22180933d8"
                        userHashMap["cover"] = "https://firebasestorage.googleapis.com/v0/b/messengerapp-68b25.appspot.com/o/fon.png?alt=media&token=e5c6c567-c1e4-4416-a91d-1a7c4db30ec7"
                        userHashMap["website"] = "https://www.google.com/"
                        userHashMap["search"] = username.toLowerCase()
                        userHashMap["instagram"] = "https://www.instagram.com/"
                        userHashMap["facebook"] = "https://www.facebook.com/"
                        userHashMap["vk"] = "https://www.vk.com/"

                        refUsers.updateChildren(userHashMap)
                            .addOnCompleteListener {task ->
                                if (task.isSuccessful)
                                {
                                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                    }
                    else
                    {
                        Toast.makeText(this@RegisterActivity, "Ошибка:" + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}