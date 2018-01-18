package cl.efredz.chileanhueater.views

import android.support.v4.app.DialogFragment
import io.reactivex.disposables.CompositeDisposable

/**
 * Base Fragment activity
 */
open class BaseRxFragment : DialogFragment() {
    protected var subscriptions = CompositeDisposable()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeDisposable()
    }


    override fun onPause() {
        super.onPause()
        if(!subscriptions.isDisposed){
            subscriptions.dispose()
        }
        subscriptions.clear()
    }
}