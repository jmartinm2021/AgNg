package com.example.agng

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mostrar el fragmento de login al inicio
        if (savedInstanceState == null) {
            replaceFragment(LoginFragment()) // Muestra el fragmento de login inicialmente
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment) // Asegúrate de que tu contenedor tenga el ID correcto
        transaction.commit()
    }
}