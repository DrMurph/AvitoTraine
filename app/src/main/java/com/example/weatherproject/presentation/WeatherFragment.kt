package com.example.weatherproject.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.weatherproject.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)

        viewModel.searchResult.observe(viewLifecycleOwner,::handleResult)

        viewModel.load()
        return binding.root
    }

    private fun handleResult(state : WeatherViewModel.WeatherResult){
        when(state){
            is WeatherViewModel.WeatherResult.SuccessResult ->{
                binding.textView.text = state.result.name
            }

        }
    }
}