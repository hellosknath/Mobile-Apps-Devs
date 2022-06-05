package com.sriidea.udemyandroidlearning

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.sriidea.udemyandroidlearning.databinding.FragmentEmailBinding

/**
 * A simple [Fragment] subclass.
 */
class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)

        binding.submitButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.emailEditText.text.toString())) {
                Toast.makeText(requireContext(), "Empty Email", Toast.LENGTH_SHORT).show()
            } else {
                val name: String? = requireArguments().getString("user_name")
                val bundle: Bundle =
                    bundleOf(
                        "user_email" to binding.emailEditText.text.toString(),
                        "user_name" to name
                    )
                it.findNavController()
                    .navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
            }

        }

        return binding.root
    }
}
