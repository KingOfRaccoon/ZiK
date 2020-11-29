package com.kingofraccoon.zik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.kingofraccoon.zik.request.Request
import java.time.LocalDateTime
import java.util.*

class RequestAdapter: RecyclerView.Adapter<RequestAdapter.Companion.RequestViewHolder>() {
    var listRequest = mutableListOf<Request>()

    fun addToList(list: MutableList<Request>){
        listRequest.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        return RequestViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.request_adapter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bind(listRequest[position])
    }

    override fun getItemCount(): Int = listRequest.size

    companion object{
        class RequestViewHolder(view : View): RecyclerView.ViewHolder(view){
            val card : CardView = view.findViewById(R.id.card)
            val id : TextView = view.findViewById(R.id.idRequest)
            val subdivision : TextView = view.findViewById(R.id.subdivision)
            val time : TextView = view.findViewById(R.id.time)
            val status : TextView = view.findViewById(R.id.status)
            fun bind(request: Request){
                id.text = request.serviceCode.toString()
                subdivision.text = request.subdivision
                time.text = request.createTime.toString()
                status.text = request.cargoInfo
            }
        }
    }
}