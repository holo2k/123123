package com.example.worldcinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

lateinit var name: EditText
lateinit var secondName: EditText
lateinit var email: EditText
lateinit var password: EditText
lateinit var confirmPassword: EditText
class signUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        name = findViewById(R.id.editTextTextEmailAddress)
        secondName = findViewById(R.id.editTextTextPassword)
        email = findViewById(R.id.editTextTextPassword2)
        password = findViewById(R.id.editTextTextPassword3)
        confirmPassword= findViewById(R.id.editTextTextPassword4)

    }

    fun login(view: android.view.View)
    {
        val intent = Intent(this@signUpActivity,SignInActivity::class.java)
        startActivity(intent)
    }

    val pattern = ("[a-z0-9]{1,256}" +
            "\\@"+
            "[a-z0-9]{1,10}" +
            "\\."+
            "[a-z]{1,3}")


    fun EmailValid (email:String):Boolean{
        return Pattern.compile(pattern).matcher(email).matches()}

    fun registration(view: android.view.View)
    {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()
            && name.text.toString().isNotEmpty() && secondName.text.toString().isNotEmpty()
            && confirmPassword.text.toString().isNotEmpty())
        {
            if(EmailValid(email.text.toString())){
                val alert = AlertDialog.Builder(this)
                    .setTitle("")
                    .setMessage("Вы зарегистрировались")
                    .setPositiveButton("OK", null)
                    .create()
                    .show()
                val intent = Intent(this@signUpActivity,SignInActivity::class.java)
                startActivity(intent)
            }
            else{
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Введите корректный E-mail")
                    .setPositiveButton("OK", null)
                    .create()
                    .show()
            }

        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
}