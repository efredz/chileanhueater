package cl.efredz.chileanhueater

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import cl.efredz.chileanhueater.adapters.CityResumeAdapter
import cl.efredz.chileanhueater.models.City
import cl.efredz.chileanhueater.models.Region
import cl.efredz.chileanhueater.views.AddCityFragment

import kotlinx.android.synthetic.main.activity_resumen_ciudades.*
import kotlinx.android.synthetic.main.content_resumen_ciudades.*

class MainActivity : AppCompatActivity(), AddCityFragment.OnFragmentInteractionListener{

    private val recycler by lazy{
        recyclerResumen
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen_ciudades)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
            val fragment = AddCityFragment()
            fragment.show(supportFragmentManager, "Hola")
        }
        bindRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_resumen_ciudades, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun bindRecyclerView(){
        val city = City("Valparaíso", Region("Región de Valparaíso"), R.drawable.valparaiso)
        val city2 = City("Santiago", Region("Región Metropolitana"), R.drawable.valparaiso)
        val cities = listOf<City>(city, city2)
        val adapter = CityResumeAdapter(cities)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);// GridLayoutManager(this , 2)
        recycler.adapter = adapter
    }

}
