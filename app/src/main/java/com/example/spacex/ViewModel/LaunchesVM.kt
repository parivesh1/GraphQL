package com.example.spacex

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.example.SpaceX.LaunchListQuery
import com.example.SpaceX.apolloClient
import kotlinx.coroutines.launch

class LaunchVM : ViewModel() {

    val launchList: MutableLiveData<List<LaunchListQuery.Launch >> = MutableLiveData()

    fun getLaunches() {
        viewModelScope.launch{
            try {
                val response = apolloClient.query(LaunchListQuery()).await()
                launchList.value = response?.data?.launches?.launches?.filterNotNull()
            } catch (e: ApolloException) {
            }
        }
    }
}