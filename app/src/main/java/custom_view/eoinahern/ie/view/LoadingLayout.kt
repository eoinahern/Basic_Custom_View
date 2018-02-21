package custom_view.eoinahern.ie.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import custom_view.eoinahern.ie.R


class LoadingLayout: FrameLayout {

	private lateinit var  image : ImageView
	private lateinit var text : TextView
	private lateinit var prog : ProgressBar

	constructor(cont: Context) : super(cont) {
		init()
	}
	 constructor(cont: Context, arrts: AttributeSet) : super(cont, arrts) {
		init()
	}
	 constructor(cont: Context, arrts: AttributeSet, defStyleAttr: Int) : super(cont, arrts, defStyleAttr) {
		init()
	}

	private fun init() {

		var v : View =  inflate(context, R.layout.loading_view, this)

		image = v.findViewById(R.id.image) as ImageView
		text = v.findViewById(R.id.text) as TextView
		prog = v.findViewById(R.id.prog) as ProgressBar
	}

	public fun  hide() {
		visibility = View.INVISIBLE
	}

	companion object {
		enum class State {
			LOADING,
			ERROR
		}
	}


	public fun show(state : State) {

		when(state) {
			State.ERROR ->  {
				image.visibility = View.VISIBLE
				prog.visibility = View.INVISIBLE
				text.text = "error occurred!!"
			}
			else -> {
				prog.visibility = View.VISIBLE
				text.text = "Loading!!"

			}
		}
	}

}