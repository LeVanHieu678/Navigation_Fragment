package com.vti.navigatedemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vti.navigatedemo.databinding.FragmentHomeBinding

class HomeFragment :Fragment() {
    private var mViewBinding : FragmentHomeBinding ? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentHomeBinding.inflate(inflater,container,false)
        return mViewBinding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       mViewBinding?.btnLogin?.setOnClickListener{
           val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
           findNavController().navigate(action)
       }

    }
}