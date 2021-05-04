package com.carpet.goharshad.ui.utils

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import androidx.core.util.Preconditions
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.carpet.goharshad.ui.utils.ArgumentKeysConstants.REQUEST_KEY
import com.carpet.goharshad.ui.utils.ArgumentKeysConstants.RESULT_KEY
import com.google.android.material.bottomsheet.BottomSheetBehavior

@SuppressLint("RestrictedApi")
fun Fragment.setUpResultListener(
    requestK: String = REQUEST_KEY,
    resultK: String = RESULT_KEY,
    action: (data: Any?) -> Unit
) {
    parentFragmentManager.setFragmentResultListener(requestK, this) { key, result ->
        Preconditions.checkState(requestK == key)
        action(result.get(resultK))
    }
}

fun Fragment.setResultWithFMExtension(
    data: Any,
    requestK: String = REQUEST_KEY,
    resultK: String = RESULT_KEY
) {
    setFragmentResult(
        requestK,
        bundleOf(resultK to data)
    )
}

fun Fragment.setResult(
    data: Any,
    requestK: String = REQUEST_KEY,
    resultK: String = RESULT_KEY
) {
    parentFragmentManager.setFragmentResult(
        requestK,
        bundleOf(resultK to data)
    )
}

fun <T : ViewBinding> Fragment.viewBinding(
    viewBindingFactory: (View) -> T,
    beforeDestroyCallback: (T.() -> Unit)? = null
) = ViewBindingProperty(this, viewBindingFactory, beforeDestroyCallback)

fun Fragment.getNotificationPendingIntent(
    taskId: Long?,
    parameterKey: String,
    notificationDestination: Int
): PendingIntent {
    val args = Bundle().also { bundle ->
        taskId?.let {
            bundle.putLong(parameterKey, it)
        }
    }

    return findNavController()
        .createDeepLink()
        .setArguments(args)
        .setDestination(notificationDestination)
        .createPendingIntent()
}

fun Fragment.dismissKeyboard() {
    val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(requireView().rootView.windowToken, 0)
}

/**
 * Call this method (in onActivityCreated or later) to set
 * the width of the dialog to a percentage of the current
 * screen width.
 */
fun DialogFragment.setWidthPercent(percentage: Int) {
    val percent = percentage.toFloat() / 100
    val dm = Resources.getSystem().displayMetrics
    val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
    val percentWidth = rect.width() * percent
    dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
}

fun Fragment.expandBottomSheet(view: View, layoutParams: ViewGroup.LayoutParams) {
    lateinit var behavior: BottomSheetBehavior<*>

    val rectangle = Rect()
    requireActivity().window.decorView.getWindowVisibleDisplayFrame(rectangle)
    val statusBarHeight: Int = rectangle.top

    behavior = BottomSheetBehavior.from(view.parent as View)
    behavior.state = BottomSheetBehavior.STATE_EXPANDED
    layoutParams.height = getWindowHeight() - statusBarHeight
}

@Suppress("DEPRECATION")
fun Fragment.getWindowHeight(): Int {
    val displayMetrics = DisplayMetrics()
    requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.heightPixels
}