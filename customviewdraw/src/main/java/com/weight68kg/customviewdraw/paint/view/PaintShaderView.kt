package com.weight68kg.customviewdraw.paint.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class PaintShaderView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var paint = Paint()

    init {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var left = 0F
        var top = 0F

        var linearGradient =
            LinearGradient(
                left,
                top,
                (width / 2).toFloat(),
                (height / 2).toFloat(),
                Color.parseColor("#ff0000"),
                Color.parseColor("#000000"),
                Shader.TileMode.CLAMP
            )
        paint.setShader(linearGradient)
        canvas.drawRect(left, top, (width / 2).toFloat(), (height / 2).toFloat(), paint)

        left = (width / 2).toFloat()
        top = 0F
        var radialGradient = RadialGradient(
            left + width / 4,
            top + height / 4,
            Math.max((height / 4).toFloat(), (width / 4).toFloat()),
            Color.parseColor("#ff0000"),
            Color.parseColor("#000000"),
            Shader.TileMode.CLAMP
        )
        paint.setShader(radialGradient)
        canvas.drawRect(left, top, left + (width / 2).toFloat(), top + (height / 2).toFloat(), paint)


        left = 0F
        top = (height / 2).toFloat()
        var sweepGradient = SweepGradient(left + width / 4, top + height / 4,Color.parseColor("#ff0000"),
            Color.parseColor("#000000"))
        paint.setShader(sweepGradient)
        canvas.drawRect(left, top, left + (width / 2).toFloat(), top + (height / 2).toFloat(), paint)


    }
}