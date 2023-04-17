package com.example.demoretrofit


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.demoretrofit.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    companion object {
        fun newInstance(): DetailFragment {
            return DetailFragment()
        }
        fun newInstance(item: Album): DetailFragment {
            return DetailFragment().apply {
                this.item = item
            }
        }
    }
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var item: Album? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setScreen(item!!)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    fun setScreen(item: Album) {
        Glide.with(this@DetailFragment).load(item.url).into(binding.detailImage)
        binding.detailAlbum.text = item.albumId.toString()
        binding.detailDes.text = item.title
    }
}