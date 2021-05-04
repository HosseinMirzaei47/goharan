package com.carpet.goharshad.ui.bindingadapters

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import coil.load
import com.bumptech.glide.Glide
import com.carpet.goharshad.ui.R
import com.carpet.goharshad.ui.utils.EpoxyEventListener
import com.carpet.goharshad.ui.utils.OnSingleClickListener
import com.google.android.material.card.MaterialCardView
import com.google.android.material.chip.Chip

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String) {
    load(url) {
        crossfade(true)
    }
}

@BindingAdapter("goneUnless")
fun View.goneUnless(value: Boolean) {
    isGone = value
}

@BindingAdapter("visibleUnless")
fun View.visibleUnless(hide: Boolean) {
    isVisible = !hide
}

@BindingAdapter("invisibleUnless")
fun View.invisibleUnless(visible: Boolean) {
    isInvisible = !visible
}

@BindingAdapter("goneIfNull")
fun View.goneIfNull(value: Any?) {
    isGone = value == null
}

@BindingAdapter("onSafeClick")
fun View.setOnSafeClick(callback: () -> Unit) {
    setOnClickListener(OnSingleClickListener { callback() })
}

@BindingAdapter("onLongClick")
fun View.onLongClick(action: () -> Unit) {
    setOnLongClickListener { action(); true }
}

@BindingAdapter("enabledColor")
fun View.enabledColor(value: Boolean) {
    isEnabled = value
    backgroundTintList = getColorStateList(value, context)
}

fun getColorStateList(enabled: Boolean, context: Context) = if (enabled) {
    ColorStateList.valueOf(
        ContextCompat.getColor(
            context, R.color.gs_secondary
        )
    )
} else {
    ColorStateList.valueOf(
        ContextCompat.getColor(
            context, R.color.darker_gray
        )
    )
}

@BindingAdapter("onCheckedChange")
fun CheckBox.onCheckedChange(action: EpoxyEventListener) {
    setOnClickListener {
        action.onEvent(isChecked)
    }
}

@BindingAdapter("onCheckedChange")
fun Chip.onCheckedChange(action: EpoxyEventListener) {
    setOnClickListener {
        action.onEvent(isChecked)
    }
}

@BindingAdapter("setStrokeColorRes")
fun MaterialCardView.setStrokeColorRes(@ColorRes color: Int) {
    strokeColor = ContextCompat.getColor(context, color)
}

@BindingAdapter("loadImageRes")
fun ImageView.loadImageRes(@DrawableRes imageRes: Int) {
    Glide.with(context).load(imageRes).into(this)
}

@BindingAdapter("setCompleteCounts")
fun TextView.setCompleteCounts(count: Int) {
    text = context.getString(
        R.string.complete_count,
        count
    )
}

@BindingAdapter("setStrike")
fun TextView.setStrike(flag: Boolean) {
    paintFlags = if (flag)
        paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    else
        paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()

}

@BindingAdapter("goneUnlessWithAnimation")
fun View.goneUnlessWithAnimation(value: Boolean) {
    if (value) {
        animate().alpha(0.0f).withEndAction {
            isGone = true
        }
    } else {
        animate().alpha(1.0f).withStartAction {
            isGone = false
        }
    }
}