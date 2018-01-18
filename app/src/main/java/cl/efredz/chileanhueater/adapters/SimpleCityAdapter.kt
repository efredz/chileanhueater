package cl.efredz.chileanhueater.adapters

import android.support.v4.app.DialogFragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cl.efredz.chileanhueater.R
import cl.efredz.chileanhueater.adapters.SimpleCityAdapter.ViewHolder
import cl.efredz.chileanhueater.models.dtos.CityDto
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_simple_city.view.*

/**
 * Created by edgardo on 08-01-18.
 */
class SimpleCityAdapter(val cityList: List<CityDto>) : RecyclerView.Adapter<ViewHolder>(){

    private val clickSubject = PublishSubject.create<CityDto>()
    var callingFragment: DialogFragment? = null

    constructor(cityList: List<CityDto>, cityFragment: DialogFragment) : this(cityList){
        callingFragment = cityFragment
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = parent!!.inflate(R.layout.item_simple_city)
        view.setOnClickListener{ _ ->
            callingFragment?.dismiss()
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItems(cityList[position])
    }


    override fun getItemCount(): Int {
        return cityList.size
    }

    val clickEvent: Observable<CityDto> = clickSubject

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init{
            itemView.setOnClickListener{
                clickSubject.onNext(cityList[layoutPosition])
            }
        }

        fun bindItems(city: CityDto){
            itemView.cityName.text = city.nombre;
        }
    }
}