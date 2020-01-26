package com.example.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.utils.base.BaseActivity
import com.example.myapplication.utils.extension.obtainViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : BaseActivity<DashboardViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = R.layout.fragment_dashboard
        viewModel = this.obtainViewModel(DashboardViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        build(container)
        val textView: TextView = rootView.text_dashboard
        viewModel.text.observe(this, Observer {
            textView.text = it
        })
        return rootView
    }
}