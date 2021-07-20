package com.vti.mvvmmodule

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.vti.mvvmmodule.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding :ActivityMainBinding? = null
    private var mList = listOf(1,2,3,4,5,6,7,8,9)

    private val viewModel by lazy {
       ViewModelProvider(this).get(SimpleViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding?.lifecycleOwner = this
        binding?.vm = viewModel
//        binding?.btnSignIn?.setOnClickListener {
//            gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build()
//          mGoogleSignInClient = gso?.let { GoogleSignIn.getClient(this, it) }
//            startActivity(Intent(mGoogleSignInClient?.signInIntent))
//        }
//        binding?.btnSignOut?.setOnClickListener {
//            mGoogleSignInClient?.signOut()
//        }

    }

}