package com.sriidea.udemyandroidlearning.presentation

import android.app.Application
import com.sriidea.udemyandroidlearning.BuildConfig
import com.sriidea.udemyandroidlearning.presentation.di.Injector
import com.sriidea.udemyandroidlearning.presentation.di.artist.ArtistSubComponent
import com.sriidea.udemyandroidlearning.presentation.di.core.*
import com.sriidea.udemyandroidlearning.presentation.di.movie.MovieSubComponent
import com.sriidea.udemyandroidlearning.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
       return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}