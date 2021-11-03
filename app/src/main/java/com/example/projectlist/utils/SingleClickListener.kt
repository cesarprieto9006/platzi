package com.example.projectlist.utils

import android.view.View

class SingleClickListener(private val interval: Long = 0, private val click: ((View) -> Unit)) :
    View.OnClickListener {
    override fun onClick(v: View?) {
        if (enabled) {
            enabled = !enabled
            v?.postDelayed(ENABLE_AGAIN, interval)
            v?.let(click)
        }
    }

    private companion object {
        @JvmStatic
        private var enabled = true
        private val ENABLE_AGAIN = Runnable { enabled = true }
    }
}