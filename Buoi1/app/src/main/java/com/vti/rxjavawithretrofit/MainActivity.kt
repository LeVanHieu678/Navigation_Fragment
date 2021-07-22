package com.vti.rxjavawithretrofit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TestInterface {
    private var mAdapter :AndroidAdapter?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         rcvAndroidVersion.hasFixedSize()
        progress_bar.visibility = View.VISIBLE
        requestAndroidVersionFromServer()
    }


    private fun requestAndroidVersionFromServer() {
        Repository.createService(ApiService::class.java)
            .getAndroidVersion()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    onSuccess ->
                    run {
                        progress_bar.visibility = View.GONE
                        mAdapter = AndroidAdapter(onSuccess)
                        rcvAndroidVersion.adapter = mAdapter

                    }
                },
                {
                    onFailure ->
                    run {
                        progress_bar.visibility = View.GONE
                        onFailure.toString().showToast(onFailure.toString(), this@MainActivity)
                    }
                }
            )
    }

    override fun Moethod1(): String {
      return  Method2()
    }

    override fun Method2(): String {
        return super.Method2()
    }
}