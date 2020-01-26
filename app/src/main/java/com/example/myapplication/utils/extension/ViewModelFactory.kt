package com.example.myapplication.utils.extension

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.dashboard.DashboardViewModel
import com.example.myapplication.ui.home.HomeViewModel
import com.example.myapplication.ui.notifications.NotificationsViewModel

class ViewModelFactory private constructor(
    private val mApplication: Application
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel()
                isAssignableFrom(DashboardViewModel::class.java) -> DashboardViewModel()
                isAssignableFrom(NotificationsViewModel::class.java) -> NotificationsViewModel()
                else -> throw IllegalArgumentException("${modelClass.name} of ViewModel not Registered")
            }
        } as T

    companion object {

        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(mApplication: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(mApplication)
                    .also { INSTANCE = it }
            }

    }
}