package com.tool.base.utils

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tool.base.R

abstract class BaseBottomSheetDialogFragment: BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)
    }
}
