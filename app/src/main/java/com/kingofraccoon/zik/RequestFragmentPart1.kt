package com.kingofraccoon.zik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment

class RequestFragmentPart1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.request_fragment_patr1, container, false)
        val firstTextView : TextView = view.findViewById(R.id.text_first_group)
        val secondTextView : TextView = view.findViewById(R.id.text_second_group)
        val thirdTextView : TextView = view.findViewById(R.id.text_third_Group)
        val firstSpinner : Spinner = view.findViewById(R.id.spinner_first_group)
        val secondSpinner : Spinner = view.findViewById(R.id.spinner_second_group)
        val thirdSpinner : Spinner = view.findViewById(R.id.spinner_third_Group)


        return view
    }
}