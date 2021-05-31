package com.carpet.fees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carpet.fees.databinding.FragmentFeesBinding
import kotlin.random.Random

class FeesFragment : Fragment() {

    private lateinit var binding: FragmentFeesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeesBinding.inflate(
            inflater, container, false
        ).apply { lifecycleOwner = viewLifecycleOwner }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFees.withModels {
            repeat(21) {
                serviceFee {
                    id(Random.nextInt())
                    icon(R.drawable.ic_wallet)
                    title(getString(R.string.service_carpet_cleaning))
                }
            }
        }
    }

}