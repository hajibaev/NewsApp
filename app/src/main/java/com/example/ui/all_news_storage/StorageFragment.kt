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
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

@AndroidEntryPoint
class StorageFragment : Fragment() {
    private val binding by lazy {
        FragmentStorageFrgmentBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<NewsStorageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() = with(viewModel) {
        binding.apply {
            lifecycleScope.launchWhenStarted {
                allNewsFlow.onEach { articles ->
                    savedProgress.isVisible = false
                    initRecycler(articles)
                    iconFavorite.isVisible = articles.isEmpty()
                }.onStart {
                    savedProgress.isVisible = true
                }.catch {
                    savedProgress.isVisible = false
                }.collect()
            }
        }
    }

    private fun initRecycler(list: List<ArticlesPresentation>) {
        binding.savedRv.adapter =
            NewsStorageAdapter(list, object : NewsStorageAdapter.RecyclerFavOnClickListener {
                override fun onItemClick(position: Int) {
                    activity?.intent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(list[position].url.toString()))
                    startActivity(activity?.intent)
//                    startActivity(intent)
                }

                override fun onClearItemClick(position: Int) {
                    list[position].url?.let { viewModel.deleteMovie(it) }
                    makeToast("News (${list[position].title}) Удалён")
                }
            })
    }

    private fun makeToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}

