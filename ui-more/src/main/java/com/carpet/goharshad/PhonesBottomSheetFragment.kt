package com.carpet.goharshad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.carpet.goharshad.databinding.FragmentBottomSheetPhonesBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PhonesBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetPhonesBinding
    private val viewModel by viewModels<PhonesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetPhonesBinding.inflate(
            inflater, container, false
        ).apply {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

}