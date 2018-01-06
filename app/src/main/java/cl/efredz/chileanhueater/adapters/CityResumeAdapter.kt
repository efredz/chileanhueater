package cl.efredz.chileanhueater.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.efredz.chileanhueater.R
import cl.efredz.chileanhueater.models.City
import kotlinx.android.synthetic.main.item_resumen.view.*

/**
 * Created by edgardo on 03-01-18.
 */
class CityResumeAdapter (val  listaCiudades: List<City>) : RecyclerView.Adapter<CityResumeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CityResumeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_resumen, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityResumeAdapter.ViewHolder, position: Int) {
        holder.bindItems(listaCiudades[position]);
    }

    override fun getItemCount(): Int {
        return listaCiudades.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(city: City){
            itemView.ciudad.text = city.name;
            itemView.region.text = city.region.name
            itemView.headerImage.setImageResource(city.headerImage)
        }

    }

}