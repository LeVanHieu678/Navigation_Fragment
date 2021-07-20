package com.vti.bindingwithrecycleview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vti.bindingwithrecycleview.R
import com.vti.bindingwithrecycleview.databinding.ItemEmployeeBinding
import com.vti.bindingwithrecycleview.model.Employee

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    private var employees = mutableListOf<Employee>()

     class EmployeeViewHolder(var employeeItemBinding: ItemEmployeeBinding) :
        RecyclerView.ViewHolder(employeeItemBinding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemBinding: ItemEmployeeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_employee,
            parent, false
        )
        return EmployeeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val currentEmployee = employees[position]
        holder.employeeItemBinding.employee = currentEmployee

    }

    override fun getItemCount(): Int {
        return employees.size
    }
    fun setEmployee(employeeList: MutableList<Employee>){
        employees.addAll (employeeList)
        notifyDataSetChanged()
    }
}