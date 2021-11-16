package com.example.worldcinema.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.worldcinema.R
import com.example.worldcinema.SignInActivity
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController


class ProfileFragment : Fragment() {
    lateinit var button : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,

    ): View? {

        //val root: View = inflater.inflate(R.layout.fragment_profile, container, false)
        //return root


        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        button = view.findViewById(R.id.buttonExit)

        button.setOnClickListener{
            val builder = this.context?.let { it1 -> AlertDialog.Builder(it1) }
            if (builder != null) {
                builder.setTitle("Уведомление")
                    .setMessage("Вы уверены что хотите выйти?")
                    .setPositiveButton("Да")
                    { dialog, which -> startActivity(Intent(activity, SignInActivity::class.java)) }
                    .setNegativeButton("Нет", null)
                    .create()
                    .show()
            }
        }

        return view

    }



}

