package cl.efredz.chileanhueater.services

import cl.efredz.chileanhueater.models.dtos.CityDto
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by edgardo on 08-01-18.
 */

interface MeteoChileApi{
    @GET("localidad/getAll")
    fun getAll() : Call<List<CityDto>>
}