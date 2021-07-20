package com.vti.navigatedemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vti.navigatedemo.databinding.FragmentLoginBinding

class LoginFragment :Fragment() {
    private var mViewBinding: FragmentLoginBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentLoginBinding.inflate(inflater,container,false)
        return mViewBinding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding?.btnConfirm?.setOnClickListener{
            val username = mViewBinding?.edtUserName?.text.toString()
            val password = mViewBinding?.edtPassWord?.text.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToWelComeFragment(username,password)
            findNavController().navigate(action)
        }
    }
}