package com.wifihckppsshu.wifihack.views.custom_loader;

import android.view.animation.Animation;
import android.view.animation.Transformation;


public class CircleLoaderAnimation extends Animation {

    private CircleLoader circleLoader;

    private float oldAngle;
    private float newAngle;

    public CircleLoaderAnimation(CircleLoader circleLoader, int newAngle) {
        this.oldAngle = circleLoader.getAngle();
        this.newAngle = newAngle;
        this.circleLoader = circleLoader;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);

        circleLoader.setAngle(angle);
        circleLoader.requestLayout();
    }
}