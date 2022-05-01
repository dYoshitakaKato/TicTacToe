package com.example.myapplication

import android.content.res.Resources
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter

object ColorUtil {
    @RequiresApi(Build.VERSION_CODES.M)
    @JvmStatic
    @BindingAdapter("color")
    fun loadColor(view: View, str: String) {
        if (str == "") {
            view.setBackgroundColor(view.resources.getColor(R.color.purple_500, Resources.getSystem().newTheme()))
            return
        }
        if (str == "○") {
            view.setBackgroundColor(view.resources.getColor(R.color.black, Resources.getSystem().newTheme()))
            return
        }
        view.setBackgroundColor(view.resources.getColor(R.color.teal_200, Resources.getSystem().newTheme()))
    }
}