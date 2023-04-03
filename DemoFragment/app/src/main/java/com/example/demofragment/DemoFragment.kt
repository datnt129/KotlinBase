package com.example.demofragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demofragment.databinding.FragmentDemoBinding

class DemoFragment : Fragment() {

    interface DemoFragmentCallback {
        fun onBack()
    }

    companion object {
        fun newInstance(title: String, callback: DemoFragmentCallback? = null): DemoFragment {
            return DemoFragment().apply {
                this.title = title
                this.callback = callback
            }
        }
    }

    private var _binding: FragmentDemoBinding? = null

    private val binding get() = _binding!!

    private var title = "NON"
    private var callback: DemoFragmentCallback? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDemoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtFragName.text = title
        binding.btnBack.setOnClickListener {
            callback?.onBack()
        }
    }

    fun setScreenName(name : String) {
        binding.txtFragName.text = name
    }

    override fun onDestroyView() {
        Log.d("AnhVM", "$title onDestroyView")
        _binding = null
        super.onDestroyView()
    }
}