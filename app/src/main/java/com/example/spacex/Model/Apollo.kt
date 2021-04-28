package com.example.SpaceX

import com.apollographql.apollo.ApolloClient

val apolloClient: ApolloClient = ApolloClient.builder()
    .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com")
    .build()!!
