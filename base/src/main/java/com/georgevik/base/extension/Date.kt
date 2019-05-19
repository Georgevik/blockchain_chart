package com.georgevik.base.extension

import java.text.SimpleDateFormat
import java.util.*

internal object DateFormat {
    const val FULL_DATETIME = "dd MMMM yyyy, HH:mm"
    const val DAY_MONTH_DATE = "d. MMM"
}

fun Date.formatFullDatetime(): String = this.toString(DateFormat.FULL_DATETIME)
fun Date.formatDayMonthDate(): String = this.toString(DateFormat.DAY_MONTH_DATE)

fun Date.toString(pattern: String): String {
    val format = SimpleDateFormat(pattern, Locale.getDefault())
    return format.format(this)
}