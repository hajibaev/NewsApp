package com.example.ui.all_news.all_top_head_lines

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.R
import com.example.base.BaseFragment
import com.example.databinding.FragmentTopNewsBinding
import com.example.models.ArticlesPresentation
import com.example.ui.adapters.NewsAdapter
import com.example.ui.all_news.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class TopNewsFragment :
    BaseFragment<FragmentTopNewsBinding, NewsViewModel>(FragmentTopNewsBinding::inflate),
    NewsAdapter.RecyclerOnClickListener,
    AdapterView.OnItemSelectedListener {

    private val adapter by lazy {
        NewsAdapter(this)
    }
    override val viewModel by viewModels<NewsViewModel>()

    private val spinnerAdapter by lazy {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.top_news_spinner_categories,
            (R.layout.spiner_item)
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchText()
        observeViewModel()
        setUi()
    }


    private fun setUi() = with(requireBinding()) {
        typeSpinner.onItemSelectedListener = this@TopNewsFragment
        typeSpinner.adapter = spinnerAdapter
        topNewsRv.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.error.onEach {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            requireBinding().generalProgress.visibility = View.VISIBLE

        }
        lifecycleScope.launchWhenStarted {
            viewModel.topNewsStateFlow.collectLatest {
                adapter.submitList(it.articles)
                requireBinding().generalProgress.visibility = View.INVISIBLE
            }
        }
    }

    private fun searchText() = requireBinding().serchViewHeadlines.apply {
        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.updateKeyword(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.updateKeyword(newText.toString())
                return true
            }
        })
        setOnCloseListener {
            false
        }
    }

    override fun onItem(url: String) {
        activity?.intent =
            Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(activity?.intent)
    }

    override fun onLongItem(articlesPresentation: ArticlesPresentation) {
        viewModel.save(articlesPresentation)
        makeToast("save")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when (position) {
            0 -> viewModel.updateCategory(BUSINESS)
            1 -> viewModel.updateCategory(ENTERTAINMENT)
            2 -> viewModel.updateCategory(GENERAL)
            3 -> viewModel.updateCategory(HEALTH)
            4 -> viewModel.updateCategory(SCIENCE)
            5 -> viewModel.updateCategory(SPORTS)
            6 -> viewModel.updateCategory(TECHNOLOGY)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) = Unit

    companion object {
        const val BUSINESS = "business"
        const val ENTERTAINMENT = "entertainment"
        const val GENERAL = "general"
        const val HEALTH = "health"
        const val SCIENCE = "science"
        const val SPORTS = "sports"
        const val TECHNOLOGY = "technology"
    }

    private fun makeToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onReady(savedInstanceState: Bundle?) {}
}
