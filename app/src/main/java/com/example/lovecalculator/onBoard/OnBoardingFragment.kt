package com.example.lovecalculator.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.data.Pref

import com.example.lovecalculator.databinding.FragmentOnBoardingBinding
import com.example.lovecalculator.di.AppModule
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
private lateinit var binding: FragmentOnBoardingBinding

    @Inject
    lateinit var pref:Pref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentOnBoardingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref.addPref(requireContext())
        val adapter = OnBoardingAdapter{
            pref.saveShowBoarding(false)
            findNavController().navigateUp()
        }
        binding.viewPager.adapter = adapter
    }
}