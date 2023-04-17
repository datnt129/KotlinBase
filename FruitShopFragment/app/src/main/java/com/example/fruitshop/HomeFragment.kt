package com.example.fruitshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitshop.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerView.layoutManager = layoutManager

        val dataset = DataSource().Categories()
        val callBack = object: CategoriesAdapter.CallBack {
            override fun onClick(item: Categories) {
                val listProductFragment = ListProductFragment.newInstance()
                parentFragmentManager.beginTransaction().add(R.id.main_fragment_frame, listProductFragment).addToBackStack("Categories").commit()
            }

        }
        binding.categoriesRecyclerView.adapter = CategoriesAdapter(dataset, callBack)

        binding.seeAllTxt.setOnClickListener {
            val categoriesFragment = ListProductFragment.newInstance()
            parentFragmentManager.beginTransaction().add(R.id.main_fragment_frame, categoriesFragment).addToBackStack("Categories").commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}