package io.realworld.api

import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.http.Query

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun `GET articles`(
    ){
        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by author`(
    ){
        runBlocking {
            val articles = conduitClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by tags`(
    ){
        runBlocking {
            val articles = conduitClient.api.getArticles(tag = "welcome")
            assertNotNull(articles.body()?.articles)
        }
    }
}