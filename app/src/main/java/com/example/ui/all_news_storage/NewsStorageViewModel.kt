package com.example.ui.all_news_storage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain
import com.example.domain.repository.StorageRepository
import com.example.models.ArticlesPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsStorageViewModel @Inject constructor(
    private val repository: StorageRepository,
    private val mappers: Mapper<List<ArticlesDomain>, List<ArticlesPresentation>>
) : ViewModel() {

    val allNewsFlow: Flow<List<ArticlesPresentation>> = repository.getStorageMovies().map(mappers::map)

    fun deleteMovie(url: String) = viewModelScope.launch {
       repository.deleteNews(url)
    }
}