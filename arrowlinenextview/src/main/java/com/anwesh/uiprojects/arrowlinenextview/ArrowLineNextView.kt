package com.anwesh.uiprojects.arrowlinenextview

/**
 * Created by anweshmishra on 15/10/19.
 */

import android.view.View
import android.app.Activity
import android.content.Context
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas

val nodes : Int = 5
val scGap : Float = 0.02f
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#673AB7")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawArrow(size : Float, paint : Paint) {
    for (i in 0..1) {
        save()
        translate(size, 0f)
        rotate(45f * (1 - 2 * i))
        drawLine(0f, 0f, -size, 0f, paint)
        restore()
    }
}

fun Canvas.drawArrowLine(w : Float, size : Float, scale : Float, paint : Paint) {
    save()
    translate((w - size) * scale.divideScale(0, 2), 0f)
    drawArrow(size, paint)
    restore()
    save()
    translate((w - size) * scale.divideScale(1, 2), size)
    drawLine(0f, 0f, size, 0f, paint)
    restore()
}

fun Canvas.drawALNNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(w / 2, gap * (i + 1))
    drawArrowLine(w, size, scale, paint)
    restore()
}

