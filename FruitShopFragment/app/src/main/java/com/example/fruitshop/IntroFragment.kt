package com.example.fruitshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fruitshop.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    interface IntroFragmentCallBack {
        fun onBack()
    }

    companion object {
        fun newInstance(callBack: IntroFragmentCallBack? = null): IntroFragment {
            return IntroFragment().apply {
                this.callBack = callBack
            }
        }
    }

    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    private var callBack: IntroFragmentCallBack? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStaredButton.setOnClickListener {
            callBack?.onBack()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}