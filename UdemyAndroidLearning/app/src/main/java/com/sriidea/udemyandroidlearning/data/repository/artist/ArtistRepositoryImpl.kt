package com.sriidea.udemyandroidlearning.data.repository.artist

import android.util.Log
import com.sriidea.udemyandroidlearning.data.model.artist.Artist
import com.sriidea.udemyandroidlearning.data.model.artist.ArtistList
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sriidea.udemyandroidlearning.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfMovies = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDb(newListOfMovies)
        artistCacheDataSource.saveArtistToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getArtistFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtist()
            val body: ArtistList? = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (ex: Exception) {
            Log.d("MYTAG", ex.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDb(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDb()
        } catch (ex: Exception) {
            Log.d("MYTAG", ex.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDb(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (ex: Exception) {
            Log.d("MYTAG", ex.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromDb()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}