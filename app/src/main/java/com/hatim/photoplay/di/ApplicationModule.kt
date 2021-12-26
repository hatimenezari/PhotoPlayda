package com.hatim.photoplay.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.bumptech.glide.Glide
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideGlide(@ApplicationContext context: Context) = Glide.with(context)

    @Provides
    fun provideSessionSharedPreferences(@ApplicationContext context: Context) =
        context.getSharedPreferences(
            SESSION, MODE_PRIVATE
        )

    companion object {
        const val SESSION = "SESSION"
    }
}