package com.example.spacex.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.example.SpaceX.RocketsQuery
import com.example.SpaceX.apolloClient
import kotlinx.coroutines.launch

class RocketsVM : ViewModel() {

    val rocketsList: MutableLiveData<List<RocketsQuery.Launch>> = MutableLiveData()

    fun getRockets() {
        viewModelScope.launch{
            try {
                val response = apolloClient.query(RocketsQuery()).await()
                rocketsList.value = response?.data?.launches?.launches?.filterNotNull()
            } catch (e: ApolloException) {
            }
        }
    }
}