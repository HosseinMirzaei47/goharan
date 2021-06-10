package com.carpet.goharshad

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.carpet.goharshad.databinding.FragmentContactUsBinding
import com.carpet.goharshad.shared.AppConstants
import com.carpet.goharshad.ui.utils.EventObserver

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

        viewModel.onPhoneClicked.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(ContactUsFragmentDirections.actionContactUsFragmentToPhonesBottomSheetFragment())
        })

        viewModel.onWhatsAppClicked.observe(viewLifecycleOwner, EventObserver {
            openWhatsAppWith(getString(it))
        })

        viewModel.onEmailClicked.observe(viewLifecycleOwner, EventObserver { sendEmail() })

    }

    private fun openWhatsAppWith(number: String) {
        val url = "https://api.whatsapp.com/send?phone=$$number"
        val whatsAppIntent = Intent(Intent.ACTION_VIEW)
        whatsAppIntent.data = Uri.parse(url)
        startActivity(whatsAppIntent)
    }

    private fun sendEmail() {
        val mailto = "mailto:" + AppConstants.FEEDBACK_EMAIL_ADDRESS +
                "?cc=" + "" +
                "&subject=" + Uri.encode(getString(R.string.feedback_email_subject)) +
                "&body=" + Uri.encode("")
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse(mailto)
        try {
            startActivity(emailIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                context,
                getString(R.string.error_email_not_installed),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}