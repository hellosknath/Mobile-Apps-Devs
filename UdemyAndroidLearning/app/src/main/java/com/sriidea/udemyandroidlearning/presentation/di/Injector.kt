package com.sriidea.udemyandroidlearning.presentation.di

import com.sriidea.udemyandroidlearning.presentation.di.artist.ArtistSubComponent
import com.sriidea.udemyandroidlearning.presentation.di.movie.MovieSubComponent
import com.sriidea.udemyandroidlearning.presentation.di.tvshow.TvShowSubComponent

interface Injector {
   fun createMovieSubComponent(): MovieSubComponent
   fun createTvShowSubComponent(): TvShowSubComponent
   fun createArtistSubComponent(): ArtistSubComponent
}