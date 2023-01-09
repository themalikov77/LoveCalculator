package com.example.lovecalculator.resultLove

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App

import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultLoveBinding
import com.example.lovecalculator.history.HistoryAdapter
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

class ResultLoveFragment : Fragment() {
    private lateinit var adapter: HistoryAdapter
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
        checkClick()
    }
    private fun initUi() {
        val data: LoveModel = arguments?.getSerializable("key") as LoveModel
        binding.resultYou.text = data.firsName
        binding.resultMe.text = data.secondName
        binding.tvResult.text = data.percentage
        binding.tvYourScore.text = data.result

    }

    private fun checkClick() {
        binding.btnAgain.setOnClickListener {
            R.id.loveCalculator
        }

        binding.tvHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }
}