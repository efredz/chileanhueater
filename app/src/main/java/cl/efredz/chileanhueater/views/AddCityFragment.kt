package cl.efredz.chileanhueater.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import cl.efredz.chileanhueater.R
import cl.efredz.chileanhueater.adapters.SimpleCityAdapter
import cl.efredz.chileanhueater.models.dtos.CityDto
import cl.efredz.chileanhueater.repositories.CityRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_add_city.*

class AddCityFragment : BaseRxFragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: AddCityInteractionListener? = null

    private val recycler by lazy{
        recyclerAddCity
    }

    private val cityRepository by lazy{
        CityRepository()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getArguments() != null) {
            mParam1 = getArguments()!!.getString(ARG_PARAM1)
            mParam2 = getArguments()!!.getString(ARG_PARAM2)
        }
        bindViews()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                     savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_city, container, false)
    }

    fun onCitySelected(city: CityDto) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(city)
        }
    }

    fun bindViews(){
        val subscription = cityRepository.getAllCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        ciudades ->
                        val adapter = SimpleCityAdapter(ciudades, this as DialogFragment)
                        adapter.clickEvent
                                .subscribe(
                                        {
                                            Toast.makeText(activity, "Apretaste " + it.nombre, Toast.LENGTH_LONG).show()
                                            onCitySelected(it)
                                            this.dismiss()
                                        })
                        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        recycler.adapter = adapter
                        Log.i("", "")
                    },
                    {
                        e ->
                        Log.e("", "", e)
                    }
                )
        subscriptions.add(subscription)
    }

    fun setEventListener(){

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is AddCityInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException((context!!.toString() + " must implement OnFragmentInteractionListener"))
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface AddCityInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(city: CityDto)
    }


    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddCityFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): AddCityFragment {
            val fragment = AddCityFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.setArguments(args)
            return fragment
        }
    }
}
