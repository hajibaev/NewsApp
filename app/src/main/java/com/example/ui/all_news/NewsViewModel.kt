package com.example.ui.all_news

import androidx.lifecycle.viewModelScope
import com.example.base.BaseViewModel
import com.example.domain.Mapper
import com.example.domain.helper.DispatchersProvider
import com.example.domain.models.ArticlesDomain
import com.example.domain.models.NewsDomain
import com.example.domain.repository.Repository
import com.example.domain.repository.StorageRepository
import com.example.models.ArticlesPresentation
import com.example.models.NewsPresentation
import com.example.ui.all_news.all_everything.EverythingFragmentDirections
import com.example.utils.resource.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: Repository,
    private val listMapper: Mapper<NewsDomain, NewsPresentation>,
    private val mapper: Mapper<ArticlesPresentation, ArticlesDomain>,
    private val resourceProvider: ResourceProvider,
    private val storageRepository: StorageRepository,
    private val dispatchersProvider: DispatchersProvider
) : BaseViewModel() {

    private val _errorFlow = MutableSharedFlow<String>(replay = 0)
    val error get() = _errorFlow.asSharedFlow()

    private val sortByFlow = MutableStateFlow("relevancy")
    private val keywordFlow = MutableStateFlow("")

    private val sortByAndKeywordFlow = sortByFlow.combine(keywordFlow) { sortBy, keyword ->
        Pair(sortBy, keyword)
    }

    val allNewsSharedFlow = sortByAndKeywordFlow.flatMapLatest { sortTypes ->
        repository.getEverything(sortTypes.second, sortBy = sortTypes.first)
    }.map(listMapper::map).flowOn(dispatchersProvider.default())
        .catch { error: Throwable -> _errorFlow.emit(resourceProvider.handleException(error)) }
        .shareIn(viewModelScope, SharingStarted.Lazily, 1)

    fun save(articleUi: ArticlesPresentation) = viewModelScope.launch {
        storageRepository.saveNews(mapper.map(articleUi))
    }

    val topNewsStateFlow = sortByAndKeywordFlow.flatMapLatest { sortTypes ->
        repository.getTopHeadLines(query = sortTypes.second, category = sortTypes.first)
    }.map(listMapper::map).flowOn(dispatchersProvider.default())
        .catch { error: Throwable -> _errorFlow.emit(resourceProvider.handleException(error)) }
        .shareIn(viewModelScope, SharingStarted.Lazily, 1)

    fun updateCategory(sortBy: String) = sortByFlow.tryEmit(sortBy)
    fun updateSortBy(sortBy: String) = sortByFlow.tryEmit(sortBy)
    fun updateKeyword(keyword: String) = keywordFlow.tryEmit(keyword)

    fun goToSettings() =
        navigate(EverythingFragmentDirections.actionEverythingFragmentToSettingFragment())
}

