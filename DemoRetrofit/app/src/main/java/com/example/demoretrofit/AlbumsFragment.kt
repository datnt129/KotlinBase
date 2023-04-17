package com.example.demoretrofit


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.demoretrofit.databinding.FragmentAlbumsBinding
import com.example.demoretrofit.retrofit.IAlbumApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AlbumsFragment : Fragment() {
    companion object {
        fun newInstance(): AlbumsFragment {
            return AlbumsFragment()
        }
    }

    private var _binding: FragmentAlbumsBinding? = null
    private val binding get() = _binding!!
    private lateinit var callback: AlbumAdapter.CallBack

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callback = object: AlbumAdapter.CallBack {
            override fun onBack(item: Album, image: ImageView) {
                Glide.with(this@AlbumsFragment).load(item.thumbnailUrl).into(image)

                image.setOnClickListener {
                    var detailFragment = DetailFragment.newInstance(item)
                    parentFragmentManager.beginTransaction().add(R.id.main_frame_layout, detailFragment).addToBackStack("Detail").commit()
                }
            }

        }
        callApi()
        binding.albumsRecycleView.layoutManager = GridLayoutManager(this.context, 2)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    fun callApi() {
        IAlbumApi.alBumApi.getPhotos().enqueue(object: Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                val dataset = response.body()
                if (dataset != null) {
                    binding.albumsRecycleView.adapter = AlbumAdapter(callback, dataset)
                }
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {

            }

        })
    }
}
