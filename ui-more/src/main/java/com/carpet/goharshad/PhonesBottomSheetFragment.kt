package com.carpet.goharshad

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.carpet.goharshad.databinding.FragmentBottomSheetPhonesBinding
import com.carpet.goharshad.ui.utils.EventObserver
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onNumberOneClicked.observe(viewLifecycleOwner, EventObserver {
            callNumber(getString(it))
        })

        viewModel.onNumberTwoClicked.observe(viewLifecycleOwner, EventObserver {
            callNumber(getString(it))
        })

        viewModel.onNumberThreeClicked.observe(viewLifecycleOwner, EventObserver {
            callNumber(getString(it))
        })

    }

    private fun callNumber(number: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }

}