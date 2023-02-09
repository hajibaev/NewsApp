package com.example.ui.all_news_storage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.databinding.FragmentStorageFrgmentBinding
import com.example.models.ArticlesPresentation
import com.example.ui.adapters.NewsStorageAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class StorageFragment : Fragment(), NewsStorageAdapter.RecyclerFavOnClickListener {

    private val binding by lazy {
        FragmentStorageFrgmentBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<NewsStorageViewModel>()


    private val newsAdapter: NewsStorageAdapter by lazy {
        NewsStorageAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.savedRv.adapter = newsAdapter
        initObserver()
    }

    private fun initObserver() = with(viewModel) {
        binding.apply {
            lifecycleScope.launchWhenStarted {
                allNewsFlow.collectLatest {
                    newsAdapter.submitList(it)
                    iconFavorite.isVisible = it.isEmpty()
                }
            }
        }
    }

    private fun makeToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(url: String) {
        activity?.intent =
            Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(activity?.intent)
    }

    override fun onClearItemClick(article: ArticlesPresentation) {
        viewModel.deleteMovie(article.url.toString())
        makeToast("News (${article.title}) Удалён")
    }
}

