package com.example.lovecalculator.loveCalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentLoveCalculatorBinding
import com.example.lovecalculator.history.HistoryViewModel
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveCalculatorFragment : Fragment() {

   private val viewModel: LoveViewModel by viewModels()
    private  val historyViewModel: HistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    private lateinit var binding: FragmentLoveCalculatorBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()).observe(viewLifecycleOwner,
                    Observer {
                        historyViewModel.getInsert(it)
                        findNavController().navigate(
                        R.id.resultLove, bundleOf("key" to it)

                        )
                    })


            }
        }

    }
}



