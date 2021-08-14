package com.alkesh.scoreboard.common.util

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


object DateAndTimeUtil {

    fun getCalendar(stringDate: String, format: DateFormats): Calendar {
        val sdf = SimpleDateFormat(format.value, Locale.ENGLISH)
        val date = sdf.parse(stringDate)
        val cal = Calendar.getInstance()
        cal.time = date
        return cal
    }

    fun formatCalender(cal: Calendar, type: DateFormats): String? {
        return try {
            val d = Date(cal.timeInMillis)
            SimpleDateFormat(type.value, Locale.ENGLISH).format(d)
        } catch (exp: Exception) {
            null
        }
    }



}

enum class DateFormats(var value: String) {
    Server_Date_Format("dd MMM yyyy hh:mm"),
    UIDateFormat("EEE dd  MMM"),
    UITimeFormat("hh:mm aa"),


}