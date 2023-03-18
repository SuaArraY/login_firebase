package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btningresar : Button = findViewById(R.id.btnIngresar)
        val txtemail : TextView = findViewById(R.id.edtEmail)
        val txtpass : TextView = findViewById(R.id.edtPass)
firebaseAuth = Firebase.auth
        btningresar.setOnClickListener()
        {
          signIn(txtemail.text.toString(), txtpass.text.toString())
        }
    }
    private fun signIn(email: String, password: String){

      firebaseAuth.signInWithEmailAndPassword(email, password)
          .addOnCompleteListener(this){task ->
              if (task.isSuccessful)
              {
                  val user = firebaseAuth.currentUser
                  Toast.makeText(baseContext,user?.uid.toString(),Toast.LENGTH_LONG).show()
              }
              else
              {
                  Toast.makeText(baseContext,"Error",Toast.LENGTH_LONG).show()
              }

          }


    }


}