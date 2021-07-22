package com.vti.rxjavawithretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlin.math.log

class RxActivity : AppCompatActivity() {
    private var disposable : Disposable? = null
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.download_activity)
        val footballPlayerObserver: Observer<String> = getFootBallPlayerObserver()
        val footballPlayerObservable: Observable<String> = getFootBallPlayerObservable()
        footballPlayerObservable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter{
                it.toLowerCase().startsWith("m")
            }
            .subscribeWith(footballPlayerObserver)
    }

    private fun getFootBallPlayerObservable(): Observable<String> =
        Observable.just("Messi", "Ronaldo", "Salah","Modric", "Mbappe")

    private fun getFootBallPlayerObserver(): Observer<String> =
        object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
                disposable = d
                Log.d("hieulv: ", "OnSubscribe")
            }

            override fun onNext(value: String?) {
                Log.d("hieulv", value.toString())
            }

            override fun onError(e: Throwable?) {
                e?.message?.let { Log.d("hieulv: ", it) }
            }

            override fun onComplete() {
                Log.d("hieulv", "All items are emitted!")
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }


}