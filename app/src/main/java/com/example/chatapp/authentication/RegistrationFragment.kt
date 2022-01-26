package com.example.chatapp.authentication

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.chatapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_registration.view.*


class RegistrationFragment : Fragment() {

    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        view.registrationRegistrationButton.setOnClickListener {
            val name = view.registrationNameEditText.text.toString()
            val lastName = view.registrationLastNameEditText.text.toString()
            val email = view.registrationEmailEditText.text.toString()
            val password = view.registrationPasswordEditText.text.toString()
            val confirmPassword = view.registrationConfirmPasswordEditText.text.toString()

            if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                view.registrationPasswordEditText.setText("")
                view.registrationConfirmPasswordEditText.setText("")
                Toast.makeText(activity, "Fields are empty", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                view.registrationPasswordEditText.setText("")
                view.registrationConfirmPasswordEditText.setText("")
                Toast.makeText(activity, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else if (password.count() < 8) {
                view.registrationPasswordEditText.setText("")
                view.registrationConfirmPasswordEditText.setText("")
                Toast.makeText(
                    activity,
                    "Password is weak, please enter at least 8 characters",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                AlertDialog.Builder(requireContext())
                    .apply {
                        setPositiveButton("ok") { _, _ ->
                            val user = User(
                                name,
                                lastName,
                                email,
                                "https://t4.ftcdn.net/jpg/00/64/67/63/240_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg"
                            )

                            FirebaseAuth.getInstance()
                                .createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {

                                        db.child(FirebaseAuth.getInstance().currentUser?.uid!!)
                                            .setValue(user)
                                        Toast.makeText(
                                            activity,
                                            "Account created successfully",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                        FirebaseAuth.getInstance().currentUser?.sendEmailVerification()
                                        Toast.makeText(
                                            activity,
                                            "Send verification link to email",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                        findNavController().popBackStack()

                                    } else {
                                        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                                    }

                                }
                        }
                        setNegativeButton("cancel") { _, _ -> }
                        setTitle("Registration")
                        setMessage("A confirmation message will be sent to the specified mail")
                        create()
                        show()
                    }
            }
        }

        return view
    }

}