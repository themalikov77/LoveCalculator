package com.example.lovecalculator.loveCalculator
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.LoveViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentLoveCalculatorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveCalculatorFragment : Fragment() {
    private val viewModel: LoveViewModel by viewModels()

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
                            findNavController().navigate(
                                R.id.resultLove,
                                bundleOf(
                                    "key" to it))

                        })



            }
        }

    }
}



