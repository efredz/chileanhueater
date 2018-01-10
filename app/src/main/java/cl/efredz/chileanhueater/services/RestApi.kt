package cl.efredz.chileanhueater.services

import cl.efredz.chileanhueater.models.dtos.CityDto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by edgardo on 08-01-18.
 */

class RestApi {
    private val redditApi: MeteoChileApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://archivos.meteochile.gob.cl/dmc-movil/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        redditApi = retrofit.create(MeteoChileApi::class.java)
    }

    fun getAllCities() : Call<List<CityDto>>{
        return redditApi.getAll()
    }
}