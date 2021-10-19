package com.example.worldcinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        val timer = object : CountDownTimer(3000, 1000) {
            //Действие во время работы таймера
            override fun onTick(millisUntilFinished: Long) {

            }

            //Действие после окончания таймера
            override fun onFinish() {
                val intent =
                    Intent(this@LaunchActivity, SignInActivity::class.java) //Переход на другой экран
                startActivity(intent) //Активация перехода
                finish() //Закрытие экрана и удаление данных
            }
        }
        timer.start() //Активация таймера
    }
}