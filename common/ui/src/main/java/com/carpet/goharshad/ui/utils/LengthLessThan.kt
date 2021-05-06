package com.carpet.goharshad.ui.utils

import com.partsoftware.formmanager.exception.ExceptionMessageParams
import com.partsoftware.formmanager.exception.MessageParamTypes
import com.partsoftware.formmanager.rules.base.ValidationSimpleRule

class LengthLessThan(
    private val length: Int,
    private val stringParam: Int? = null
) : ValidationSimpleRule() {
    override fun validate(value: String?) {
        if (!value.isNullOrBlank() && value.length > length) {
            stringParam?.let {
                ExceptionMessageParams(MessageParamTypes.STRING, it)
            } ?: ExceptionMessageParams(MessageParamTypes.HINT, null)
        }
    }
}