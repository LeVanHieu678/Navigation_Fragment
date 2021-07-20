package com.vti.bindingwithrecycleview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vti.bindingwithrecycleview.R
import com.vti.bindingwithrecycleview.adapter.EmployeeAdapter
import com.vti.bindingwithrecycleview.databinding.ActivityEmployeeBinding
import com.vti.bindingwithrecycleview.model.Employee
import com.vti.bindingwithrecycleview.viewmodel.EmployeeViewModel


class EmployeeActivity: AppCompatActivity() {
    private var binding: ActivityEmployeeBinding? = null
    private var vmEmployee: EmployeeViewModel? = null
    private var mAdapter: EmployeeAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  =  DataBindingUtil.setContentView(this, R.layout.activity_employee)
        val rcvEmployee = binding?.rcvEmployee
        rcvEmployee?.hasFixedSize()
        rcvEmployee?.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        mAdapter = EmployeeAdapter()
        vmEmployee  = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        rcvEmployee?.adapter = mAdapter
        vmEmployee?.getData()?.observe(this,
            { t ->
                t?.let {
                    mAdapter?.setEmployee(it)
                }
            })





    }
}