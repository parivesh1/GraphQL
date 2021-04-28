package com.example.spacex.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.example.SpaceX.MissionListQuery
import com.example.SpaceX.apolloClient
import kotlinx.coroutines.launch

class MissionsVM : ViewModel() {

    val missionList: MutableLiveData<List<MissionListQuery.Launch>> = MutableLiveData()

    fun getMissions() {
        viewModelScope.launch{
            try {
                val response = apolloClient.query(MissionListQuery()).await()
                missionList.value = response?.data?.launches?.launches?.filterNotNull()
            } catch (e: ApolloException) {
            }
        }
    }
}