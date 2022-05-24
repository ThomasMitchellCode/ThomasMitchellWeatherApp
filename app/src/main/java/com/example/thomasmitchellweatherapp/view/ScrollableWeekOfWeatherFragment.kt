package com.example.thomasmitchellweatherapp.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thomasmitchellweatherapp.R
import com.example.thomasmitchellweatherapp.databinding.FragmentScrollableWeekOfWeatherBinding
import com.example.thomasmitchellweatherapp.model.CityWeatherItem
import com.example.thomasmitchellweatherapp.repository.WeatherRepositoryImpl
import com.example.thomasmitchellweatherapp.viewmodel.WeatherViewModel


class ScrollableWeekOfWeatherFragment(private var city: String?) : Fragment() {

    private var _binding: FragmentScrollableWeekOfWeatherBinding? = null
    private val binding: FragmentScrollableWeekOfWeatherBinding get() = _binding!!

    private lateinit var weatherRecyclerAdapter: WeatherRecyclerAdapter

    private val viewModel: WeatherViewModel by lazy {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return WeatherViewModel(WeatherRepositoryImpl()) as T
            }
        }.create(WeatherViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScrollableWeekOfWeatherBinding.inflate(layoutInflater)

        binding.tvCityName.text = city

        binding.tvCityName.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        viewModel.getForecast(city)
        configureObserver()

        return binding.root
    }


    private fun configureObserver() {
        weatherRecyclerAdapter = WeatherRecyclerAdapter(openDetails = ::openDetails)

        viewModel.forecast.observe(viewLifecycleOwner) {
            response ->
                if (response.result.isNotEmpty()) {
                    weatherRecyclerAdapter.setForecast(response.result)
                    binding.rvScrollableWeekOfWeather.adapter = weatherRecyclerAdapter
                }
        }
    }

    private fun openDetails(cityWeatherItem: CityWeatherItem) {
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                DetailedDayOfWeatherFragment.newInstance(cityWeatherItem, city)
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}