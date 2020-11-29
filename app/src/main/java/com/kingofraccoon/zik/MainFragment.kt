package com.kingofraccoon.zik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        val bottomNavigationView : BottomNavigationView = view.findViewById(R.id.bnv)
        val mainFrame : FrameLayout = view.findViewById(R.id.main_frame)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.request ->{
                    requireFragmentManager().beginTransaction()
                            .add(R.id.main_frame, RequestFragment())
                            .addToBackStack(null)
                            .commit()
                }
                R.id.history ->{
                    requireFragmentManager().beginTransaction()
                            .add(R.id.main_frame, HistoryFragment())
                            .addToBackStack(null)
                            .commit()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        return view
    }
}