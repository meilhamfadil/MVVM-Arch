package com.example.myapplication.utils.base

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseActivity<T : BaseViewModel> : Fragment() {

    lateinit var viewModel: T
    lateinit var rootView: View
    var layout: Int = 0

    fun build(container: ViewGroup?) {
        rootView = layoutInflater.inflate(layout, container, false)
    }

}