package com.kingofraccoon.zik

import com.kingofraccoon.zik.place.Place
import com.kingofraccoon.zik.request.Request

object CreateRequest {
    var bodyFirst = ""
    var goalFirst = ""
    var prpFirst = ""

    var bodySecond = ""
    var goalSecond = ""
    var prpSecond = ""

    var places = mutableListOf<Place>()
    var subdivision = ""
    fun createFirstPlace(): Place {
        return Place(prpFirst, goalFirst, bodyFirst)
    }

    fun createSecondPlace(): Place{
        return Place(prpSecond, goalSecond, bodySecond)
    }
}