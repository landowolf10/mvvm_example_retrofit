package com.example.mvvmexample.data.network

import com.example.mvvmexample.core.RetrofitHelper
import com.example.mvvmexample.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService
{
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>
    {
        return withContext(Dispatchers.IO)
        {
            val response: Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java)
                .getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}