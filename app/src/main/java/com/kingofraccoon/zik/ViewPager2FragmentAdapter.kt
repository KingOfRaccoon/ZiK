package com.kingofraccoon.zik

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2FragmentAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    val listFragment = mutableListOf<Fragment>( )
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        if (position == 0)
            return RequestFragment()
        else
            return HistoryFragment()
    }
}