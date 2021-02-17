package com.mstf.basekotlinmvvm.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import kotlin.math.roundToInt

object ViewUtils {
    fun changeIconDrawableToGray(context: Context, drawable: Drawable) {
        drawable.mutate()
        drawable.setColorFilter(
            ContextCompat.getColor(context, android.R.color.darker_gray),
            PorterDuff.Mode.SRC_ATOP
        )
    }

    fun dpToPx(dp: Float): Int {
        val density = Resources.getSystem().displayMetrics.density
        return (dp * density).roundToInt()
    }

    fun pxToDp(px: Float): Float {
        val densityDpi = Resources.getSystem().displayMetrics.densityDpi.toFloat()
        return px / (densityDpi / 160f)
    }
}