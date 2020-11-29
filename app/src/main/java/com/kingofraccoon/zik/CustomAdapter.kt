package com.kingofraccoon.zik

import android.content.Context
import android.widget.ArrayAdapter

class CustomAdapter(context: Context): ArrayAdapter<String>(context, R.layout.spinner_textview) {
    override fun getCount(): Int {
    val count = super.getCount()
    return if (count > 0) count - 1 else count
    }
}