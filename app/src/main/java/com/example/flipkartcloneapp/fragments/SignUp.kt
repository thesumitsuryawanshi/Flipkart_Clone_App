package com.example.flipkartcloneapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flipkartcloneapp.Home
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.FragmentSignUpBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class SignUp : Fragment() {

    lateinit var binding: FragmentSignUpBinding

    lateinit var mAuth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        googleSignIn()
        spinnerInit()

        binding.btnSignUp.setOnClickListener {
            val id = binding.etGmailid.text.toString()
            val pass = binding.etPassword.text.toString()
            createUser(id, pass)
        }

    }

    private fun createUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val name = binding.etName.text.toString()
                    Toast.makeText(
                        activity,
                        "Account created successfully. \n Welcome $name",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(Intent(activity, Home::class.java))
                    getActivity()?.onBackPressed()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        activity, "Something went wrong.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun googleSignIn() {

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.facebook_app_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(activity, gso)

        mAuth = FirebaseAuth.getInstance()


    }

    private fun spinnerInit() {

        val spinner: Spinner = binding.spinnerCellphoneNo

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.Cellphone_no,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

}