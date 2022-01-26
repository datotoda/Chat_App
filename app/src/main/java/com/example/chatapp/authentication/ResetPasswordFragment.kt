package com.example.chatapp.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.chatapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_reset_password.view.*


class ResetPasswordFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_reset_password, container, false)

        view.loginResetResetButton.setOnClickListener {
            val email = view.loginResetEmailEditText.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(activity , "Email is empty", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance()
                    .sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                activity,
                                "Password recovery link successfully sent to email",
                                Toast.LENGTH_LONG
                            ).show()
                            findNavController().popBackStack()
                        } else {
                            Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }



        return view
    }

}