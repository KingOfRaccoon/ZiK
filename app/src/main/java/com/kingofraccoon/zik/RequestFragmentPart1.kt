package com.kingofraccoon.zik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kingofraccoon.zik.CreateRequest.bodyFirst
import com.kingofraccoon.zik.CreateRequest.goalFirst
import com.kingofraccoon.zik.CreateRequest.prpFirst

class RequestFragmentPart1 : Fragment() {
    val def_body = "Введите корпус:"
    val def_goal = "Введите ворота:"
    val def_prp = "Введите ПРП:"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.request_fragment_patr1, container, false)

        val firstSpinner : Spinner = view.findViewById(R.id.spinner_first_group)
        val secondSpinner : Spinner = view.findViewById(R.id.spinner_second_group)
        val thirdSpinner : Spinner = view.findViewById(R.id.spinner_third_Group)

        val firstCustomAdapter = CustomAdapter(requireContext())
        val secondCustomAdapter = CustomAdapter(requireContext())
        val thirdCustomAdapter = CustomAdapter(requireContext())

        val bodies = resources.getStringArray(R.array.bodyString).toMutableList()
        val goals = resources.getStringArray(R.array.goalString).toMutableList()
        val prps = resources.getStringArray(R.array.prpString).toMutableList()

        firstCustomAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        firstCustomAdapter.addAll(bodies)
        firstCustomAdapter.add(def_body)
        firstSpinner.adapter = firstCustomAdapter
        firstSpinner.setSelection(firstCustomAdapter.count)
        firstSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (firstSpinner.selectedItem != def_body)
                    bodyFirst = bodies[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        secondCustomAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        secondCustomAdapter.addAll(goals)
        secondCustomAdapter.add(def_goal)
        secondSpinner.adapter = secondCustomAdapter
        secondSpinner.setSelection(secondCustomAdapter.count)
        secondSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (secondSpinner.selectedItem != def_goal)
                    goalFirst = goals[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        thirdCustomAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        thirdCustomAdapter.addAll(prps)
        thirdCustomAdapter.add(def_prp)
        thirdSpinner.adapter = thirdCustomAdapter
        thirdSpinner.setSelection(thirdCustomAdapter.count)
        thirdSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (thirdSpinner.selectedItem != def_prp)
                    prpFirst = prps[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        return view
    }
}