package com.wifihckppsshu.wifihack.views.custom_loader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;


public class CircleLoader extends View {

    private static final int START_ANGLE_POINT = -90;

    private final Paint paint;
    private final RectF rect;

    private float angle;

    public CircleLoader(Context context, AttributeSet attrs) {
        super(context, attrs);

        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        /**
         * Create strokeWidth depending on screen dimension
         */
        final float strokeWidth = 168 * ((float)width/720);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        //Circle color
        paint.setColor(Color.parseColor("#1c72b6"));



        rect = new RectF(strokeWidth, strokeWidth, 2 * strokeWidth, 2 * strokeWidth);

        //Initial Angle (optional, it can be zero)
        angle = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
