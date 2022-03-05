package com.jay.wallpaperapp.utils

import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jay.wallpaperapp.R

open class Resources:AppCompatActivity() {

        fun setfragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
}