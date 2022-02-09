package io.realworld.conduit.data

import io.realworld.api.ConduitClient

object ArticlesRepo{

    private val api = ConduitClient.publicApi

    suspend fun getGlobalFeed() = api.getArticles()

}