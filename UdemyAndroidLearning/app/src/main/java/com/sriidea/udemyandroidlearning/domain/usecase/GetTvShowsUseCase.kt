package com.sriidea.udemyandroidlearning.domain.usecase

import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow
import com.sriidea.udemyandroidlearning.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}