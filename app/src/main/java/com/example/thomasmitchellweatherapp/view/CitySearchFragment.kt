package com.example.thomasmitchellweatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thomasmitchellweatherapp.R
import com.example.thomasmitchellweatherapp.databinding.FragmentCitySearchBinding


class CitySearchFragment : Fragment() {
    private var _binding: FragmentCitySearchBinding? = null
    private val binding : FragmentCitySearchBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCitySearchBinding.inflate(layoutInflater)

        binding.tvLookup.setOnClickListener {
            val inputCityName = binding.etCityName.text.toString()

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(
                R.id.fragment_container,
                ScrollableWeekOfWeatherFragment(inputCityName)
            )?.addToBackStack(null)?.commit()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}