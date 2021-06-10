package com.carpet.goharshad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.carpet.goharshad.databinding.FragmentContactUsBinding

class ContactUsFragment : Fragment() {

    private lateinit var binding: FragmentContactUsBinding
    private val viewModel by viewModels<ContactUsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactUsBinding.inflate(
            inflater, container, false
        ).apply {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onPhoneClicked.observe(viewLifecycleOwner) {
            findNavController().navigate(ContactUsFragmentDirections.actionContactUsFragmentToPhonesBottomSheetFragment())
        }

    }
}