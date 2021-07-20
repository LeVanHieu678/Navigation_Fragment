package com.vti.mvvmmodule

import androidx.lifecycle.LiveData

interface Main {
    interface ViewModel{
        fun onLikes()
        fun getFirstName() : String?
        fun getLastName() : String?
        fun getLikes () : Any
        fun signInWithGoogle() : Any
        fun signOut(): Any
        fun getPopularity() : LiveData<Popularity>
    }
}