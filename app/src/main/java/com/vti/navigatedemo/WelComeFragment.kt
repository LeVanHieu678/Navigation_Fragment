package com.vti.navigatedemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vti.navigatedemo.databinding.FragmentWelcomeBinding

class WelComeFragment :Fragment() {
    private var mViewBinding: FragmentWelcomeBinding? = null
    private val args: WelComeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return mViewBinding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding?.tvUserName?.text = args.username
        mViewBinding?.tvPassWord?.text = args.password
        mViewBinding?.btnLogin?.setOnClickListener{
           val action = WelComeFragmentDirections.actionWelComeFragmentToHomeFragment()
           findNavController().navigate(action)
       }

    }
}