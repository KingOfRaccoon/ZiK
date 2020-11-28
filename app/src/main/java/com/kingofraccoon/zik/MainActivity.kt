package com.kingofraccoon.zik

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
//    val TAG_FB = "FIRE"
//    val db = FirebaseFirestore.getInstance()
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