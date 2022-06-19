package com.sriidea.udemyandroidlearning.presentation.di.tvshow

import com.sriidea.udemyandroidlearning.presentation.artist.ArtistActivity
import com.sriidea.udemyandroidlearning.presentation.tv.TVShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}