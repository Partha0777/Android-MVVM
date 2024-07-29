package com.curiozing.android_mvvm.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.curiozing.android_mvvm.R
import com.curiozing.android_mvvm.databinding.FragmentSecond2Binding
import com.curiozing.android_mvvm.home.model.HomeViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Second2Fragment : Fragment() {

    private var _binding: FragmentSecond2Binding? = null
    private lateinit var homeViewModel:HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecond2Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

        homeViewModel.count.observe(viewLifecycleOwner){
            binding.textviewSecond.text = it.toString()
        }

        binding.btnDecrease.setOnClickListener {
            homeViewModel.decrement()
        }
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_Second2Fragment_to_First2Fragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}