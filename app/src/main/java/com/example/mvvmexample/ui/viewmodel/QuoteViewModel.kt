package com.example.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.data.mockDataSource.MockQuoteDataSource
import com.example.mvvmexample.data.model.QuoteModel
import com.example.mvvmexample.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel()
{
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()

    fun onCreate()
    {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<QuoteModel>? = getQuotesUseCase()

            if(!result.isNullOrEmpty())
            {
                quoteModel.postValue(result[1])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote()
    {
        //val currentQuote: QuoteModel = MockQuoteDataSource.getRandomQuote()
        //quoteModel.postValue(currentQuote)
    }

}