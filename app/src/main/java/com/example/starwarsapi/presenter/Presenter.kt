package com.example.starwarsapi.presenter

import android.util.Log
import com.example.starwarsapi.common.Constants
import com.example.starwarsapi.common.Constants.Companion.TAG
import com.example.starwarsapi.model.StarWarsModel
import com.example.starwarsapi.network.RetrofitInstance
import com.example.starwarsapi.network.StarWarsInterface
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.create

class Presenter(_view: ViewInterface): PresenterInterface {

    override fun makeRetrofitCall(){
        var retrofit = RetrofitInstance().retrofitInstance().create(StarWarsInterface::class.java)

        var call = retrofit.getStarWars()

        call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(starWarsObserver())
    }


    var compositeDisposable = CompositeDisposable()


    fun starWarsObserver() : Observer<StarWarsModel>{
        return object : Observer<StarWarsModel>{
            override fun onComplete() {
                Log.d(Constants.TAG + " ON_COMPLETE", "All items Emitted!")
            }

            override fun onSubscribe(d: Disposable) {
                compositeDisposable.add(d)

                Log.d(Constants.TAG + " ON_SUBSCRIBE", d.toString())
            }

            override fun onNext(t: StarWarsModel) {

                view.recycle(t)
                Log.d(Constants.TAG + " ON_NEXT", t.results[0].name)
            }

            override fun onError(e: Throwable) {
                Log.d(Constants.TAG + " ON_ERROR", e.message)
            }

        }
    }

    var view = _view

    private fun starWars(starWars: StarWarsModel){
        view.recycle(starWars)
    }

    private fun animals(animal: String){
        Log.d(TAG + "ANIMALS", animal)
    }
}