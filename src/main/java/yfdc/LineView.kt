package yfdc
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
class LineView : android.view.View {
    private val mContext: Context
    private val p: android.graphics.Paint = android.graphics.Paint(0)
    constructor(context: Context) : super(context) {
        mContext = context
    }
    constructor(context: Context, attr: AttributeSet?) : super(context, attr) {
        mContext = context
    }
    constructor(context: Context, attr: AttributeSet?, var0: Int) : super(context, attr, var0) {
        mContext = context
    }
    public final override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        p.strokeWidth = 50.toFloat()
        p.color = -1
        if (null !== canvas) {
            canvas.drawLine(0.toFloat(),0.toFloat(),50.toFloat(),0.toFloat(),this.p)
            canvas.save()
        }
    }
    public final override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        android.util.Log.d("LineView","onMeasure($widthMeasureSpec,$heightMeasureSpec)")
    }
}
