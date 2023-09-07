package com.example.technicalassigment.utils

import android.content.Context
import android.content.Intent

class Utils {
    companion object{
        fun goToActivity(ctx: Context, to: Class<*>?) {
            val i = Intent(ctx, to)
             ctx.startActivity(i)
        }
    }
}