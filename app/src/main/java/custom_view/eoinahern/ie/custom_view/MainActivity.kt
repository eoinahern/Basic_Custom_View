package custom_view.eoinahern.ie.custom_view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import custom_view.eoinahern.ie.R
import custom_view.eoinahern.ie.view.LoadingLayout

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

	private lateinit var loadingLayout : LoadingLayout

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		this.loadingLayout = findViewById(R.id.loading)
		loadingLayout.show(LoadingLayout.Companion.State.LOADING)

		runCustomLoadingView()
	}

	private fun runCustomLoadingView() {

		var obs = Observable.empty<Unit>().delay(5, TimeUnit.SECONDS)


				obs.observeOn(AndroidSchedulers.mainThread())
						.subscribeOn(AndroidSchedulers.mainThread())
				.subscribe(object : Observer<Unit> {
					override fun onNext(t: Unit) {
					}

					override fun onError(e: Throwable) {
						Log.d("error", "error")
					}

					override fun onComplete() {
						Log.d("complete", "complete")
						loadingLayout.show(LoadingLayout.Companion.State.ERROR)
					}

					override fun onSubscribe(d: Disposable) {
					}
				})
	}
}
