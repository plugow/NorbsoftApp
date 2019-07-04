package com.plugow.norbsoftapp.di

import android.app.Application
import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object{
        @Provides
        @JvmStatic
        @Singleton
        fun providePicasso(ctx:Context) : Picasso {
            return Picasso.Builder(ctx).build()
        }
    }
}