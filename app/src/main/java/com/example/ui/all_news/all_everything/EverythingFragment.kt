package com.example.ui.all_news.all_everything

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceManager
import com.example.R
import com.example.base.BaseFragment
import com.example.databinding.FragmentEverythingBinding
import com.example.models.ArticlesPresentation
import com.example.ui.adapters.NewsAdapter
import com.example.ui.all_news.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, NewsViewModel>(FragmentEverythingBinding::inflate),
    NewsAdapter.RecyclerOnClickListener,
    AdapterView.OnItemSelectedListener {

    private val newsAdapter: NewsAdapter by lazy {
        NewsAdapter(this)
    }

    override val viewModel: NewsViewModel by viewModels()
    private val spinnerAdapter by lazy {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.all_news_spinner_categories,
            (R.layout.spiner_item)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchText()
        toggleDayNight()
        observeViewModel()
        setUi()
    }

    private fun toggleDayNight() {
        val currentMode = PreferenceManager.getDefaultSharedPreferences(requireContext())
            .getBoolean("theme", false)
        lifecycleScope.launchWhenCreated {
            if (currentMode) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun setUi() = with(requireBinding()) {
        typeSpinner.onItemSelectedListener = this@EverythingFragment
        typeSpinner.adapter = spinnerAdapter
        everythingRV.adapter = newsAdapter
        setting.setOnClickListener { viewModel.goToSettings() }
    }

    private fun observeViewModel() = with(viewModel) {
        error.onEach {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            requireBinding().generalProgress.visibility = View.VISIBLE
        }
        lifecycleScope.launchWhenStarted {
            allNewsSharedFlow.collectLatest {
                newsAdapter.submitList(it.articles)
                requireBinding().generalProgress.visibility = View.GONE
            }
        }
    }


    private fun searchText() = requireBinding().serchView.apply {
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
        activity?.intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(activity?.intent)
    }

    override fun onLongItem(articlesPresentation: ArticlesPresentation) {
        viewModel.save(articlesPresentation)
        makeToast("save")
    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when (position) {
            0 -> viewModel.updateSortBy(RELEVANCY)
            1 -> viewModel.updateSortBy(POPULARITY)
            2 -> viewModel.updateSortBy(PUBLISHED_AT)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) = Unit

    companion object {
        const val RELEVANCY = "relevancy"
        const val POPULARITY = "popularity"
        const val PUBLISHED_AT = "publishedAt"
    }

    private fun makeToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onReady(savedInstanceState: Bundle?) {}
}
