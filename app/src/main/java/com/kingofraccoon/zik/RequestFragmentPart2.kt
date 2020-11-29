package com.kingofraccoon.zik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment

class RequestFragmentPart2: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.request_fragment_part2, container, false)
        val firstSpinner : Spinner = view.findViewById(R.id.spinner_first_group_part2)
        val secondSpinner : Spinner = view.findViewById(R.id.spinner_second_group_part2)
        val thirdSpinner : Spinner = view.findViewById(R.id.spinner_third_group_part2)
        val fourthSpinner : Spinner = view.findViewById(R.id.spinner_fourth_group_part2)


        return view
    }
}