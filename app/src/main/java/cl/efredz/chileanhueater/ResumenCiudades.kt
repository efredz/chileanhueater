package cl.efredz.chileanhueater

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import cl.efredz.chileanhueater.adapters.CityResumeAdapter
import cl.efredz.chileanhueater.models.City
import cl.efredz.chileanhueater.models.Region

import kotlinx.android.synthetic.main.activity_resumen_ciudades.*
import kotlinx.android.synthetic.main.content_resumen_ciudades.*

class ResumenCiudades : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen_ciudades)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
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

    fun bindRecyclerView(){
        val city = City("Valparaíso", Region("Región de Valparaíso"), R.drawable.header_valparaiso)
        val city2 = City("Santiago", Region("Región Metropolitana"), R.drawable.valparaiso)
        val cities = listOf<City>(city, city2)
        val adapter = CityResumeAdapter(cities)
        recyclerResumen.layoutManager = GridLayoutManager(this , 2)
        recyclerResumen.adapter = adapter
    }
}
