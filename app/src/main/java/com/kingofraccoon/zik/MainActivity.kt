package com.kingofraccoon.zik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.setFragment(CheckFragment())
    }
    fun FragmentManager.setFragment(fragment: Fragment){
        this.beginTransaction()
                .add(R.id.frame, fragment)
                .addToBackStack(null)
                .commit()
    }
}