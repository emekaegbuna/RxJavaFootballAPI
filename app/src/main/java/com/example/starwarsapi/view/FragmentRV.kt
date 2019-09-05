package com.example.starwarsapi.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarsapi.R
import com.example.starwarsapi.model.StarWarsModel
import com.example.starwarsapi.presenter.Presenter
import com.example.starwarsapi.presenter.ViewInterface
import kotlinx.android.synthetic.main.fragment_fragment_rv.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentRV : Fragment(), ViewInterface {

    override fun recycle(starWarsModel: StarWarsModel) {
        var adapter = Adapter(starWarsModel)
        rv_fragement.layoutManager = LinearLayoutManager(activity?.applicationContext)
        rv_fragement.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_rv, container, false)
    }

    var presenter = Presenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.makeRetrofitCall()


    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.compositeDisposable.dispose()
    }


}
