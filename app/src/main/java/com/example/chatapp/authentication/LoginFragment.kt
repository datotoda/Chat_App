package com.example.chatapp.authentication

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.chatapp.R
import com.example.chatapp.chat.ChatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.loginEmailEditText
import kotlinx.android.synthetic.main.fragment_login.view.loginLoginButton
import kotlinx.android.synthetic.main.fragment_reset_password.view.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (FirebaseAuth.getInstance().currentUser != null) {
            if (FirebaseAuth.getInstance().currentUser!!.isEmailVerified){
                goToChatActivity()
            } else {
                AlertDialog.Builder(requireContext())
                    .apply {
                        setPositiveButton("Send link to email") { _, _ ->
                            FirebaseAuth.getInstance().currentUser?.sendEmailVerification()
                            Toast.makeText(
                                requireContext(),
                                "Send successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        setNegativeButton("I have already activated it") { _, _ -> }
                        setTitle("Verify Email")
                        setMessage("Please activate your account")
                        create()
                        show()
                    }
            }
        }

        val view = inflater.inflate(R.layout.fragment_login, container, false)


        view.loginLoginButton.setOnClickListener {
            val email = view.loginEmailEditText.text.toString()
            val password = view.loginPasswordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                view.loginPasswordEditText.setText("")
                Toast.makeText(activity, "Email or Password is empty", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            view.loginPasswordEditText.setText("")
                            view.loginEmailEditText.setText("")
                            activity?.recreate()
                        } else {
                            Toast.makeText(activity, "Email or Password is incorrect", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        view.loginRegistrationButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
        view.loginResetPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }


        return view
    }

    private fun goToChatActivity() {
        startActivity(Intent(activity, ChatActivity::class.java))
        activity?.finish()
    }

}