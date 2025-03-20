package com.tool.base.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatEditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.tool.base.R

class ValidatableEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val editText: AppCompatEditText by lazy { findViewById(R.id.documentEditText) }

    init {
        LayoutInflater.from (context).inflate(R.layout.validatable_edittext, this, false)
    }

}