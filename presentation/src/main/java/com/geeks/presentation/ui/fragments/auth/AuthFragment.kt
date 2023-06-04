package com.geeks.presentation.ui.fragments.auth

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.presentation.R
import com.geeks.presentation.base.BaseFragment
import com.geeks.presentation.base.RequestPermission
import com.geeks.presentation.databinding.FragmentAuthBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment : BaseFragment<FragmentAuthBinding, AuthViewModel>(R.layout.fragment_auth){

    @Inject
    lateinit var googleSignIn: GoogleSignInClient
    override val binding: FragmentAuthBinding by viewBinding(FragmentAuthBinding::bind)
    override val viewModel: AuthViewModel by viewModels()
    lateinit var requestPermission: RequestPermission

    override fun initialize() {
        requestPermission = RequestPermission()

    }

    override fun setupRequest() {
        context?.let { requestPermission.requestPermission(this, it) }
    }

    override fun setupListener() {

        with(binding) {
            btnGoogle.setOnClickListener {
                if (etInputName.text.isNotEmpty()) {
                    etInputName.apply {
                        setBackgroundResource(R.drawable.normal_edit_text)
                        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                    }
                    resultLauncher.launch(googleSignIn.signInIntent)
                } else {
                    etInputName.apply {
                        setBackgroundResource(R.drawable.error_edit_text)
                        setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.ic_priority_high,
                            0
                        )
                    }
                }
            }
        }
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                val token = task.result.idToken
                if (token != null) {
                    viewModel.auth(token,
                        onSuccess = {
                            viewModel.saveUserData(binding.etInputName.text.toString())
                            findNavController().navigate(R.id.action_authFragment_to_mapsFragment)
                        },
                        onError = {
                            Toast.makeText(
                                requireContext(),
                                "Что то не так!", Toast.LENGTH_SHORT
                            ).show()
                        })
                } else {
                    Log.e("TokenException", "No Token!")
                }
            }
        }

}