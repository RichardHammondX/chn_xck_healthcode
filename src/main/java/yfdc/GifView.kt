package yfdc

import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Movie
import android.os.SystemClock
import androidx.appcompat.widget.AppCompatImageView
import yfdc.baidu.app1.R
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build
import androidx.annotation.RequiresApi

class GifView public constructor(private val ct: android.content.Context, private val set: android.util.AttributeSet?) : AppCompatImageView(ct, set) {
    private val isGif: Boolean
    private var movie: Movie? = null
    private var imageRes: Int = 0
    @RequiresApi(28)
    private var donghua: Any? = null

    init {
        val array: TypedArray = ct.obtainStyledAttributes(set, R.styleable.GifView)
        isGif = array.getBoolean(R.styleable.GifView_isGifImage, true)
        array.recycle()
        set?.let {
            imageRes = it.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0)
            movie = Movie.decodeStream(resources.openRawResource(imageRes))
        }
        if (Build.VERSION.SDK_INT >= 28) {
            init0(ct, set)
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun init0(context: android.content.Context, attr: android.util.AttributeSet?) {
        donghua = AnimatedImageDrawable.createFromResourceStream(resources!!, null, resources!!.openRawResource(imageRes), null) as AnimatedImageDrawable
    }

    private var movieStart: Long = 0L;
    public final override fun onDraw(canvas: Canvas?) {
        if (canvas === null) {
            super.onDraw(null)
            return
        }
        val _this = this
        val curTime = SystemClock.uptimeMillis()
        if (movieStart == 0L) {
            movieStart = curTime
        }
        movie?.let {
            doWithout {
                val duration = it.duration()
                val relTime = ((curTime - movieStart) % duration).toInt()
                it.setTime(relTime)
                it.draw(canvas, 0.0f, 0.0f)
                _this.invalidate()
            }
        }
        super.onDraw(canvas)
    }
}
