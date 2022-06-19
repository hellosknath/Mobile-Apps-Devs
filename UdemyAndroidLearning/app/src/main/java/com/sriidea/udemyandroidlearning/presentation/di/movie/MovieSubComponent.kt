package com.sriidea.udemyandroidlearning.presentation.di.movie

import com.sriidea.udemyandroidlearning.presentation.di.artist.ArtistScope
import com.sriidea.udemyandroidlearning.presentation.di.tvshow.TvShowScope
import com.sriidea.udemyandroidlearning.presentation.movies.MoviesActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MoviesActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}