package com.sriidea.udemyandroidlearning.data.api

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewsApiServiceTest {
    private lateinit var service: NewAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewAPIService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadLines_sentRequest_receiveExpected() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val request = server.takeRequest()
            Truth.assertThat(responseBody).isNotNull()
            Truth.assertThat(request.path)
                .isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=f18f276bf5e84ec587ac49e4bae7d3b9")
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val articleList = responseBody!!.articles
            Truth.assertThat(articleList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val articleList = responseBody!!.articles
            val article = articleList[0]
            Truth.assertThat(article.author).isEqualTo("Steve Almasy and Melissa Alonso, CNN")
            Truth.assertThat(article.publishedAt).isEqualTo("2022-06-25T05:59:00Z")
        }
    }
}