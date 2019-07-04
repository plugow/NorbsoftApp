package com.plugow.norbsoftapp.di

import com.plugow.norbsoftapp.di.scope.ActivityScoped
import com.plugow.norbsoftapp.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    internal abstract fun mainActivity() : MainActivity

}