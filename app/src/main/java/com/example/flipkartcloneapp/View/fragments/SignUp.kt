package com.example.flipkartcloneapp.View.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.flipkartcloneapp.View.Home
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

        binding.textView9.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Terms and Conditions")
                .setMessage(
                    "The domain name www.flipkart.com \n " +
                            "(hereinafter referred to as \"Website\") is owned by" +
                            " Flipkart Internet Private Limited a company \n  incorporated under the Companies Act, 1956 with its registered office at Vaishnavi Summit, \n Ground Floor, 7th Main, 80 feet Road, 3rd Block, Koramangala Industrial Layout, \n Next to Wipro office, Corporation Ward No. 68, Koramangala, Bangalore - 560 034," +
                            " Karnataka, India (hereinafter referred to as \"Flipkart\")." +
                            " \n\n \n" +
                            "\n" +
                            ("ACCESSING, BROWSING OR OTHERWISE USING THE SITE INDICATES YOUR AGREEMENT TO ALL THE TERMS AND CONDITIONS UNDER THESE TERMS OF USE, SO PLEASE READ THE TERMS OF USE CAREFULLY BEFORE PROCEEDING. By impliedly or expressly accepting these Terms of Use, You also accept and agree to be bound by Flipkart Policies ((including but not \n " +
                                    "limited to Privacy Policy available on /s/privacypolicy) as amended " +
                                    "from time to time")
                )
                .setPositiveButton("Close") { _, _ -> }
                .show()
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
                        "Account created successfully. \n Welcome  $name",
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