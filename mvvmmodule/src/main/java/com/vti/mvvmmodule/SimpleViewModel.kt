package com.vti.mvvmmodule

import android.app.Application
import android.content.Intent
import androidx.lifecycle.*
import com.google.android.gms.auth.api.signin.*

class SimpleViewModel(application: Application): AndroidViewModel(application), Main.ViewModel {
    private var firstName = MutableLiveData("Le")
    private var lastName = MutableLiveData("Hieu")
     var countLikes = MutableLiveData(0)
    private var gso : GoogleSignInOptions? = null
    var mGoogleSignInClient : GoogleSignInClient? = null
    var googleSignInAccount : GoogleSignInAccount? = null
    init {
        googleSignInAccount = GoogleSignIn.getLastSignedInAccount(getApplication<Application>().applicationContext)
    }

    override fun onLikes() {

        countLikes.value = (countLikes.value ?: 0) + 1
    }

    override fun getFirstName(): String?{
        return googleSignInAccount?.displayName
    }
        override fun getLastName(): String? {
           return googleSignInAccount?.givenName
        }

        override fun getLikes() = countLikes
        override fun signInWithGoogle() {
            val context = getApplication<Application>().applicationContext
            gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
            mGoogleSignInClient = gso?.let { GoogleSignIn.getClient(context, it) }
            context.startActivity(Intent(mGoogleSignInClient?.signInIntent).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }

        override fun signOut() {
            mGoogleSignInClient?.signOut()
        }

        override fun  getPopularity(): LiveData<Popularity> = Transformations.map(countLikes) {
            when {
                it > 9 -> Popularity.STAR
                it > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        }
    }


enum class Popularity {
    NORMAL,
    STAR,
    POPULAR
}