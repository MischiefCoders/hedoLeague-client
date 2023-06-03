package com.hedoleague.android

import android.app.Application
import com.hedoleague.SharedEngine
import com.hedoleague.tablesModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(myModule, tablesModule)
        }
    }
}

val myModule = module {
    // ViewModel 정의
    viewModel { TablesViewModel(get()) }
    //SharedEngine 정의
    single { SharedEngine(get()) }
}
