package com.example.lovecalculator.resultLove

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.databinding.FragmentResultLoveBinding
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class
ResultLoveFragment : Fragment() {
    private lateinit var binding: FragmentResultLoveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultLoveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()

    }

    private fun initUi() {
        var data = arguments?.getSerializable("key")
        if (data != null) {
            data as LoveModel
            binding.resultMe.text = data.firsName
            binding.resultYou.text = data.secondName
            binding.tvResult.text = data.percentage
            binding.resultMe.text = data.result
        }
    }
}