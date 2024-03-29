package com.example.flipkartcloneapp.View.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.View.Home
import com.example.flipkartcloneapp.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    private val EMAIL = "email"

    companion object {
        private const val RC_SIGN_IN = 123
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        googleAuthCheck()

        binding.btnSignin.setOnClickListener {
            val id = binding.etGmailid.text.toString()
            val password = binding.etPassword.text.toString()

            SignInWithIdPass(id, password)
        }

        binding.tvSwipeRightToSignUp.setOnClickListener {
            Snackbar.make(
                binding.root,
                "CHecking the swipe right to sign up action",
                Snackbar.LENGTH_SHORT
            ).show()

            Navigation.findNavController(binding.root).navigate(R.id.GlobalActionToSignUpFrag)
        }
    }

    private fun SignInWithIdPass(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser

                    Toast.makeText(
                        activity,
                        "Sign in success. \n Welcome ${user?.email}",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(activity, Home::class.java))
                    binding.etGmailid.text.clear()
                    binding.etPassword.text.clear()
                    getActivity()?.onBackPressed()

                } else {
                    Toast.makeText(
                        activity, "Something went wrong.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }

    private fun googleAuthCheck() {
        // Configure Google Sign In
        binding.GsignInButton.setOnClickListener {
            val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.facebook_app_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(requireActivity(), options)
            googleSignInClient.signInIntent.also {
                startActivityForResult(it, RC_SIGN_IN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val account = GoogleSignIn.getSignedInAccountFromIntent(data).result
            account?.let {
                googleAuthForFirebase(it)
            }
        }
    }

    private fun googleAuthForFirebase(account: GoogleSignInAccount) {
        val credentials = GoogleAuthProvider.getCredential(account.idToken, null)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                auth.signInWithCredential(credentials)
                withContext(Dispatchers.Main) {
                    Toast.makeText(activity, "Successfully logged in. ", Toast.LENGTH_LONG).show()
                }
                val i = Intent(activity, Home::class.java)
                startActivity(i)

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        activity,
                        "something is wrong : \n" + e.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }

}
