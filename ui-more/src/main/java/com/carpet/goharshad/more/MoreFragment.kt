package com.carpet.goharshad.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.carpet.goharshad.databinding.FragmentMoreBinding
import com.carpet.goharshad.ui.utils.EventObserver

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding
    private val viewModel by viewModels<MoreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(
            inflater, container, false
        ).apply {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onContactUsClicked.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(MoreFragmentDirections.actionMoreFragmentToContactUsFragment())
        })

        viewModel.onHistoryClicked.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(MoreFragmentDirections.actionMoreFragmentToHistoryFragment())
        })

        viewModel.onDisclaimerClicked.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(MoreFragmentDirections.actionMoreFragmentToDisclaimerFragment())
        })

    }

}