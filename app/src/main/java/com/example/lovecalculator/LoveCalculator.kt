package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentLoveCalculatorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculator : Fragment() {
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalculatorBinding.inflate(inflater)
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
                RetrofitService().getLoveApi().getResult(
                    firstName = etFirstName.text.toString(),
                    secondName = etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        Log.e("ololo", "onResponse: ${response.body()?.percentage}")
                        val bundle  =   bundleOf(
                            "fname" to etFirstName.text.toString(),
                            "sname" to etSecondName.text.toString(),
                            "percentage" to response.body()?.percentage
                        )
                        findNavController().navigate(
                            R.id.action_loveCalculator_to_resultLove2, bundle)
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message} ")
                    }

                })

            }
        }
    }

}