package cl.efredz.chileanhueater.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.efredz.chileanhueater.R
import cl.efredz.chileanhueater.models.City
import cl.efredz.chileanhueater.models.dtos.CityDto
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.item_resumen.view.*
import kotlinx.android.synthetic.main.item_simple_city.view.*

/**
 * Created by edgardo on 08-01-18.
 */
class SimpleCityAdapter(val cityList: List<CityDto>) : RecyclerView.Adapter<SimpleCityAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_simple_city, parent, false)
        val view = parent!!.inflate(R.layout.item_simple_city)
        return SimpleCityAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItems(cityList[position])
    }


    override fun getItemCount(): Int {
        return cityList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(city: CityDto){
            itemView.cityName.text = city.nombre;
        }
    }
}