package com.carpet.goharshad.ui.utils

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.carpet.goharshad.ui.snackbar.SnackbarMessage
import java.util.Calendar
import java.util.Locale

fun Int.getMonthName(style: Int = Calendar.LONG): String? {
    val calendar = Calendar.getInstance()
    calendar[Calendar.MONTH] = this
    val monthDisplayName = calendar.getDisplayName(Calendar.MONTH, style, Locale.getDefault())
    calendar.clear(Calendar.MONTH)
    return monthDisplayName
}

fun Exception.getSnackBarMessage(): SnackbarMessage {
    return SnackbarMessage(
        messageId = message.hashCode(),
        message = message
    )
}

@SuppressLint("ClickableViewAccessibility")
fun View.disallowParentTouchEvents() {
    setOnTouchListener { v, event ->
        v.parent.requestDisallowInterceptTouchEvent(true)
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_UP ->
                v.parent.requestDisallowInterceptTouchEvent(false)
        }
        false
    }
}

fun <T> MutableLiveData<T>.notifyChange() {
    value = value
}