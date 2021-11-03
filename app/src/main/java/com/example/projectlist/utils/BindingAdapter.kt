package com.example.projectlist.utils

import android.view.View

fun View.setSingleClickListener(interval: Long = 0, click: (View) -> Unit) =
    setOnClickListener(SingleClickListener(interval, click))