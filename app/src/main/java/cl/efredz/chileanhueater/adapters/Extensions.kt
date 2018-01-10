package cl.efredz.chileanhueater.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by edgardo on 09-01-18.
 */
fun ViewGroup.inflate(layoutId : Int, attachRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachRoot)
}

