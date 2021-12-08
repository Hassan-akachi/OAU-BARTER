package com.example.oau_barter.extensions

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

object ContextExtensions {  //used to context objects e.g toast,snackbar ...e.t.c

    fun Context.showSnackbar(msg:String, view: View){//a snackbar context
        Snackbar.make(this, view, msg, Snackbar.LENGTH_SHORT).show()
    }

}