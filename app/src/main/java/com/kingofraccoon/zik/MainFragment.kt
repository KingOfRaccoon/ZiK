package com.kingofraccoon.zik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val viewPager2 : ViewPager2 = view.findViewById(R.id.viewpager2)
        val tabLayout : TabLayout = view.findViewById(R.id.tabs)
        viewPager2.adapter = ViewPager2FragmentAdapter(this)
        TabLayoutMediator(tabLayout, viewPager2){ tab: TabLayout.Tab, i: Int ->
            when(i){
                0 -> tab.text = "Заявка"
                1 -> tab.text = "История"
            }
            viewPager2.currentItem = i
        }.attach()
        viewPager2.currentItem = 0
        return view
    }
}