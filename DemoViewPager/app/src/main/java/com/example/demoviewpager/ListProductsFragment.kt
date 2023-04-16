package com.example.demoviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demoviewpager.databinding.FragmentListProdutcsBinding

class ListProductsFragment : Fragment() {
    companion object {
        fun newInstance(): ListProductsFragment {
            return ListProductsFragment()
        }
    }

    private var _binding: FragmentListProdutcsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListProdutcsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}