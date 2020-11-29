package com.kingofraccoon.zik

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.kingofraccoon.zik.CreateRequest.places
import com.kingofraccoon.zik.request.Request
import java.time.LocalDate
import java.time.LocalTime

class RequestFragmentPart2: Fragment() {
    val def_subDiv = "Введите подразделение:"
    val def_body = "Введите корпус:"
    val def_goal = "Введите ворота:"
    val def_prp = "Введите ПРП:"
    lateinit var request: Request
    var db = FirebaseFirestore.getInstance()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.request_fragment_part2, container, false)
        val firstSpinner : Spinner = view.findViewById(R.id.spinner_first_group_part2)
        val secondSpinner : Spinner = view.findViewById(R.id.spinner_second_group_part2)
        val thirdSpinner : Spinner = view.findViewById(R.id.spinner_third_group_part2)
        val fourthSpinner : Spinner = view.findViewById(R.id.spinner_fourth_group_part2)
        val button : Button = view.findViewById(R.id.calculate)

        val subDiv = resources.getStringArray(R.array.subdivisionString).toMutableList()
        val bodies = resources.getStringArray(R.array.bodyString).toMutableList()
        val goals = resources.getStringArray(R.array.goalString).toMutableList()
        val prps = resources.getStringArray(R.array.prpString).toMutableList()

        val firstCustomAdapter = CustomAdapter(requireContext())
        val secondCustomAdapter = CustomAdapter(requireContext())
        val thirdCustomAdapter = CustomAdapter(requireContext())
        val fourthCustomAdapter = CustomAdapter(requireContext())

        firstCustomAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        firstCustomAdapter.addAll(subDiv)
        firstCustomAdapter.add(def_subDiv)
        firstSpinner.adapter = firstCustomAdapter
        firstSpinner.setSelection(firstCustomAdapter.count)
        firstSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (firstSpinner.selectedItem != def_subDiv)
                    CreateRequest.subdivision = subDiv[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        secondCustomAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        secondCustomAdapter.addAll(bodies)
        secondCustomAdapter.add(def_body)
        secondSpinner.adapter = secondCustomAdapter
        secondSpinner.setSelection(secondCustomAdapter.count)
        secondSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (secondSpinner.selectedItem != def_body)
                    CreateRequest.bodySecond = bodies[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        thirdCustomAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        thirdCustomAdapter.addAll(goals)
        thirdCustomAdapter.add(def_goal)
        thirdSpinner.adapter = thirdCustomAdapter
        thirdSpinner.setSelection(thirdCustomAdapter.count)
        thirdSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (thirdSpinner.selectedItem != def_goal)
                    CreateRequest.goalSecond = goals[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        fourthCustomAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        fourthCustomAdapter.addAll(prps)
        fourthCustomAdapter.add(def_prp)
        fourthSpinner.adapter = fourthCustomAdapter
        fourthSpinner.setSelection(fourthCustomAdapter.count)
        fourthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (fourthSpinner.selectedItem != def_prp)
                    CreateRequest.prpSecond = prps[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        button.setOnClickListener {
            places.add(CreateRequest.createFirstPlace())
            places.add(CreateRequest.createSecondPlace())
            request = Request(places.first(), places.last()).apply { subdivision = CreateRequest.subdivision }
            val req = hashMapOf(
                    "firstBody" to request.placeOfDeparture.building,
                    "firstGoal" to request.placeOfDeparture.gates,
                    "firstPRP" to request.placeOfDeparture.prp,
                    "secondBody" to request.placeOfReceipt.building,
                    "secondGoal" to request.placeOfReceipt.gates,
                    "secondPRP" to request.placeOfReceipt.prp,
                    "status" to request.status,
                    "time" to "${LocalDate.now()}",
                    "dis" to request.subdivision
            )

            db.collection("users").document("request")
                    .set(req)
                    .addOnSuccessListener {
                        Log.d("TAG", "DocumentSnapshot successfully written!")
                    }
                    .addOnFailureListener {
                        e -> Log.w("TAG", "Error writing document", e)
                    }

        }
        return view
    }
}