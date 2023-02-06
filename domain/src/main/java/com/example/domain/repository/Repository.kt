package com.example.domain.repository

import com.example.domain.models.NewsDomain
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getEverything(query: String, sortBy: String): Flow<NewsDomain>
    fun getTopHeadLines(query: String, category: String): Flow<NewsDomain>
}