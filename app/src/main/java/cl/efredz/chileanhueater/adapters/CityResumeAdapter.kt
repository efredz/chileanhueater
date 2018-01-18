package cl.efredz.chileanhueater.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import cl.efredz.chileanhueater.R
import cl.efredz.chileanhueater.models.City
import com.afollestad.materialdialogs.MaterialDialog
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_resumen.view.*

/**
 * Created by edgardo on 03-01-18.
 */
class CityResumeAdapter (private val cityList: List<City>) : RecyclerView.Adapter<CityResumeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CityResumeAdapter.ViewHolder? {
        val view = parent?.inflate(R.layout.item_resumen)
        return ViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: CityResumeAdapter.ViewHolder, position: Int) {
        holder.bindItems(cityList[position])
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(city: City){
            itemView.ciudad.text = city.name;
            itemView.region.text = city.region.name
            itemView.headerImage.setImageResource(city.headerImage)
            itemView.setOnClickListener{
                with(MaterialDialog.Builder(itemView.context)){
                    title("Seleccionaste a la ciudad de " + city.name)
                    positiveText("Bacán")
                    negativeText("Mal")
                    onPositive{_,_ -> }
                    onNegative{_,_ -> }
                }.show()
            }
        }
    }

}