@file:JvmName("Util")
package yfdc
public inline fun <T> doWithout(block:()->T?){
    try{
        block()
    }catch (ex:Throwable){
        ex.printStackTrace(System.out)
    }
}
public fun buildStr(context:android.content.Context?,attr:android.util.AttributeSet?,defStyleAttr:Int):String{
    val rtn = StringBuilder()
    rtn.append("constructor <init>(")
    context?.let { rtn.append(it.toString()) }
    attr?.let { rtn.append(',').append(it.toString()) }
    rtn.append(',').append(defStyleAttr).append(')')
    return rtn.toString()
}