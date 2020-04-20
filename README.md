# CustomView
自定义 view学习

腾讯课堂Hencoder学习

# 绘制
* 绘制流程 
    1. 前景绘制 drawBackground(canvas);
    2. save the canvas' layers
    3. 绘制主体 onDraw(canvas);最常重写这个方法
    4. 绘制子View dispatchDraw(canvas);
    5. draw the fade effect and restore layers
    6. 绘制装饰条(例如滚动条，临界)
* 基础绘制
    * Paint
        * Paint.setColor()
        * Paint.setShader() 着色器，设置之后setColor/ARGB()不起作用
            * LinearGradient 线性渐变
            * RadialGradient 辐射渐变
            * SweepGradient 扫描渐变
            * BitmapShader 使用图片填充
            * ComposeShader 混合着色器。将两个shader一起使用
                * PorterDuff.Mode   [官方文档](https://developer.android.com/reference/android/graphics/PorterDuff.Mode.html) 
        * Paint.setColorFilter()颜色过滤
            * LightingColorFilter 模拟光照
            * ColorMatrixColorFilter 可以把绘制的像素转换，可以参考这个[项目](https://github.com/chengdazhi/StyleImageView)
            * PorterDuffColorFilter 
        * Paint.setXfermode()就是根据PorterDuff.Mode进行处理，不过需要注意使用setXfermoder()必须使用离屏缓冲(Off-screen Buffer),使用离屏缓冲有两种方式，更多离屏缓冲信息可看[官网](https://developer.android.com/guide/topics/graphics/hardware-accel.html)
            * Canvas.savaLayer() 先调用这个方法，然后再setXfermode(),最后再恢复Canvas.restoreToCount(saved)，一般使用这种就可以
            * View.setLayerType()直接把整个View都绘制在离屏缓冲中。
       * setAntiAliass(boolean aa)抗锯齿
       * setStyle(Paint.Style style)实心空心
       * 线条形状
           * setStrokeWidhth(float width)线条粗细
           * setStrokeCap(Paint.Cap cap)圆头和方头会比平头多处一块
               * BUTT 平头
               * ROUND 圆头
               * SQUARE 方头
            * setStrokeJoin(Paint.Join join)拐角形状
                * MITER 尖角
                * BEVEL 平角
                * ROUND 圆角
            * setStrokeMiter(float miter)对setStrokeJoin()的补充，用于设置MITER拐角延长线的最大值。
        * setPathEffect(PathEffect effect)图形设置轮廓
            * CornerPathEffect 所有拐角都是圆角
            * DiscretePthEffect 线条随机偏离，直线变不规则曲线
            * DashPatheffect 虚线
            * PathDashPatheffect 相当于是自定义虚线是什么样子
            * SumPathEffect 组合效果两种效果同时存在 并行
            * ComposePathEffect 组合效果 串行
        * setShaderLayer() 阴影.设置在绘制层下方的附加效果
        * setMaskFilter(MaskFilter maskFilter) 绘制层上方的附加效果
            *   BlurMaskFilter 模糊效果
            *   EmbossMaskFilter 浮雕效果
    * Canvas  
        * 绘制类方法：Canvas.drawXXX()
            * 弧 Canvas.drawArc()
            * 颜色 Canvas.drawARGB()
            * 图片 Canvas.drawBitmap()
            * 圆 Canvas.drawCircle()
            * 线 Canvas.drawLine()
            * 椭圆 Canvas.drawOval()
            * 自定义路径 Canvas.drawPath()
            * 点 Canvas.drawPoint()
            * 矩形 Canvas.drawRect()
            * 圆角矩形 Canvas.drawRoundRect()
            * 文字 Canvas.drawText()

        * 辅助绘制方法
            * 范围裁切 Canvas.clipXXX()
            * 几何变换 
                * Metrix 矩阵
                * translate() 平移
                * rotate() 旋转
                * scale() 缩放
                * skew() 拉伸，三维效果
                * Camera 专门做三维的

