package com.carpet.goharshad.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carpet.goharshad.task.databinding.FragmentServicesBinding
import com.carpet.goharshad.task.service
import kotlin.random.Random

class ServicesFragment : Fragment() {

    private lateinit var binding: FragmentServicesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServicesBinding.inflate(
            inflater, container, false
        ).apply { lifecycleOwner = viewLifecycleOwner }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvServices.withModels { repeat(21) { service { id(Random.nextInt()) } } }
    }

}