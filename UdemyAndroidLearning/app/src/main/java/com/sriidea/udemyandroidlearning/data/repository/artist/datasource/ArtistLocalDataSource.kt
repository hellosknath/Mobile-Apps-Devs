package com.sriidea.udemyandroidlearning.data.repository.artist.datasource

import com.sriidea.udemyandroidlearning.data.model.artist.Artist

interface ArtistLocalDataSource {
  suspend fun getArtistsFromDB():List<Artist>
  suspend fun saveArtistsToDB(artists:List<Artist>)
  suspend fun clearAll()
}