package com.rafamanzano.movietrailerstv.ui.main


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import androidx.lifecycle.lifecycleScope
import com.rafamanzano.movietrailerstv.R
import com.rafamanzano.movietrailerstv.data.MovieRepository
import com.rafamanzano.movietrailerstv.domain.Movie
import com.rafamanzano.movietrailerstv.data.server.RemoteConnection
import com.rafamanzano.movietrailerstv.data.server.toDomainMovie
import com.rafamanzano.movietrailerstv.ui.detail.DetailActivity
import kotlinx.coroutines.launch

class MainFragment : BrowseSupportFragment() {

    private lateinit var moviesRepository: MovieRepository
    private val backgrounState = BackgroundState(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesRepository = MovieRepository(getString(R.string.api_key))

        title = getString(R.string.browse)

        viewLifecycleOwner.lifecycleScope.launch {
            adapter = buildAdapter()
        }

        onItemViewClickedListener = OnItemViewClickedListener { vh, movie, _, _ ->
            val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                requireActivity(),
                (vh.view as ImageCardView).mainImageView,
                DetailActivity.SHARED_ELEMENT_NAME
            ).toBundle()
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra(DetailActivity.MOVIE_EXTRA, movie as Movie)
            }
            startActivity(intent, bundle)
        }

        onItemViewSelectedListener = OnItemViewSelectedListener{ _, movie, _, _ ->
            (movie as? Movie)?.let { backgrounState.loadUrl(it.backDrop) }
        }
    }

    private suspend fun buildAdapter(): ArrayObjectAdapter {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = CardPresenter()
        moviesRepository.getCategories().forEach { (category, movies) ->
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)
            listRowAdapter.addAll(0, movies)

            val header = HeaderItem(category.ordinal.toLong(), category.name)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        return rowsAdapter
    }
}