package com.kingofraccoon.zik

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.kingofraccoon.zik.place.Place
import com.kingofraccoon.zik.request.Request
import org.w3c.dom.Document
import java.text.ParsePosition
import java.text.SimpleDateFormat

class HistoryFragment: Fragment() {
    val db = FirebaseFirestore.getInstance()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.history_fragment, container, false)
        val recycler : RecyclerView = view.findViewById(R.id.recycler)
        val requestAdapter = RequestAdapter()
        recycler.adapter = requestAdapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
//        db.collection("users")
//                .document("request")
//                .get()
//                .addOnSuccessListener {
//                    requestAdapter.addToList(
//                            mutableListOf(
//                                    Request(
//                                            Place(
//                                                    it.get("firstPRP") as String,
//                                                    it.get("firstGoal") as String,
//                                                    it.get("firstBody") as String
//                                            ),
//                                            Place(
//                                                    it.get("secondPRP") as String,
//                                                    it.get("secondGoal") as String,
//                                                    it.get("secondBody") as String
//                                            )
//                                    ).apply {
//                                        this.cargoInfo = it.get("status") as String;
//                                        this.createTime = SimpleDateFormat("yyyy-mm-dd")
//                                                .parse(it.get("time") as String, ParsePosition(0))
//
//                                    }
//                            )
//                    )
//                }
//                .addOnFailureListener {  }
        db.collection("users")
                .document("request")
                .addSnapshotListener(
                        object : EventListener<DocumentSnapshot>{
                            override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                                requestAdapter.addToList(
                                        mutableListOf(
                                                Request(
                                                        Place(
                                                                value?.get("firstPRP") as String,
                                                                value.get("firstGoal") as String,
                                                                value.get("firstBody") as String
                                                        ),
                                                        Place(
                                                                value.get("secondPRP") as String,
                                                                value.get("secondGoal") as String,
                                                                value.get("secondBody") as String
                                                        )
                                                ).apply {
                                                    this.subdivision = value.getString("dis")
                                                    this.cargoInfo = value.get("status") as String;
                                                    this.createTime = SimpleDateFormat("yyyy-mm-dd")
                                                            .parse(value.get("time") as String, ParsePosition(0))
                                                }
                                        )
                                )
                            }
                        }
                )


        return view
    }
}