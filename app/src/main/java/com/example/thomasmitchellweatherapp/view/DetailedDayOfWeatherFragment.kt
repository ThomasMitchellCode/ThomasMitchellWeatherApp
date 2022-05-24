package com.example.thomasmitchellweatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thomasmitchellweatherapp.R
import com.example.thomasmitchellweatherapp.databinding.FragmentDetailedDayOfWeatherBinding
import com.example.thomasmitchellweatherapp.model.CityWeatherItem


class DetailedDayOfWeatherFragment : Fragment() {

    private var _binding: FragmentDetailedDayOfWeatherBinding? = null
    private val binding: FragmentDetailedDayOfWeatherBinding? get() = _binding

    private var city: String? = null

    companion object {
        const val KEY = "DETAILS"

        fun newInstance(cityWeatherItem: CityWeatherItem, currentCity: String?): DetailedDayOfWeatherFragment {
            val fragment = DetailedDayOfWeatherFragment()
            val bundle = Bundle()

            fragment.city = currentCity

            bundle.putParcelable(KEY, cityWeatherItem)
            fragment.arguments = bundle

            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val cityWeatherItem: CityWeatherItem? = arguments?.getParcelable(KEY)

        _binding = FragmentDetailedDayOfWeatherBinding.inflate(layoutInflater)

        binding?.tvCityTitle?.text = this.city

        binding?.tvDetailTemp?.text = cityWeatherItem?.getTemperature()
        binding?.tvDetailsFeelsLike?.text = cityWeatherItem?.getFeelsLike()
        binding?.tvDetailsDescription?.text = cityWeatherItem?.getDetailedDescription()
        binding?.tvDetailsWeatherMain?.text = cityWeatherItem?.getDescription()

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}