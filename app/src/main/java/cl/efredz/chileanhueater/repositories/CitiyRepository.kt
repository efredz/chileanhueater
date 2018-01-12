package cl.efredz.chileanhueater.repositories

import cl.efredz.chileanhueater.models.dtos.CityDto
import cl.efredz.chileanhueater.services.RestApi
import io.reactivex.Observable
import io.reactivex.Observer
import kotlinx.android.synthetic.main.item_simple_city.view.*

/**
 * Created by edgardo on 08-01-18.
 */
class CityRepository(private val restApi: RestApi = RestApi()){
    fun getAllCities(): Observable<List<CityDto>>{
        return Observable.create{
            subscriber ->
            val listado = mutableListOf<List<CityDto>>()
            val callResponse = restApi.getAllCities()
            val response = callResponse.execute()
            if(response.isSuccessful){
                val ciudades = response.body()
                subscriber.onNext(ciudades!!.sortedBy { city -> city.nombre })
                subscriber.onComplete()
            } else{
                subscriber.onError(Throwable(response.message()))
            }

        }
    }
}
