package com.weight68kg.customviewdraw

import androidx.annotation.LayoutRes
import androidx.annotation.StringRes

open class PageModel internal constructor(
    @StringRes internal var titleRes: Int,
    @LayoutRes internal var practiceLayoutRes: Int
)