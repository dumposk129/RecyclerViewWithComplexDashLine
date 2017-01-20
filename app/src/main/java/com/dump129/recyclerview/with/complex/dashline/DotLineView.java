package com.dump129.recyclerview.with.complex.dashline;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Dump129 on 1/20/2017.
 */

public class DotLineView extends View {
    private int dotColorResourceId;
    private int dotColor;
    private int dotCount;
    private boolean isMirror;

    private Paint paint;

    public DotLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUp(attrs);
    }

    public DotLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUp(attrs);
    }

    public DotLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setUp(attrs);
    }

    public void setUp(AttributeSet attrs) {
        setupStyleable(attrs);
        setupCanvasComponent();
        updateView();
    }

    private void setupCanvasComponent() {
        paint = new Paint();
        paint.setColor(getDotColor());
    }

    public void setupStyleable(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.DotLineView);
        dotColorResourceId = typedArray.getResourceId(R.styleable.DotLineView_dlv_dotColor, -1);
        dotColor = typedArray.getColor(R.styleable.DotLineView_dlv_dotColor, Color.RED);
        dotCount = typedArray.getInt(R.styleable.DotLineView_dlv_dotCount, 5);
        isMirror = typedArray.getBoolean(R.styleable.DotLineView_dlv_isMirror, false);
        typedArray.recycle();
    }

    public void setDotColor(@ColorInt int color) {
        dotColor = color;
        dotColorResourceId = -1;
        updateView();
    }

    public int getDotColor() {
        if (dotColorResourceId != -1) {
            return ContextCompat.getColor(getContext(), dotColorResourceId);
        } else {
            return dotColor;
        }
    }

    public void setDotColorResourceId(@ColorRes int resourceId) {
        dotColorResourceId = resourceId;
        updateView();
    }

    public int getDotCount() {
        return dotCount;
    }

    public void setDotCount(int dotCount) {
        this.dotCount = dotCount;
        updateView();
    }

    public boolean isMirror() {
        return isMirror;
    }

    public void setMirror(boolean mirror) {
        isMirror = mirror;
        updateView();
    }

    private void updateView() {
        if (isInEditMode()) {
            setBackgroundColor(dotColor);
        } else {
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        float dotSpacing = ((height * 2) - (width * dotCount)) / (dotCount + 1);
        int dotCount = Math.round((float) this.dotCount / 2);
        for (int index = 0; index < dotCount; index++) {
            float cx = width / 2f;
            float cy;
            if (isMirror) {
                cy = height - (width * index) - (dotSpacing * (index + 1)) - (width / 2);
            } else {
                cy = (width * index) + (dotSpacing * (index + 1)) + (width / 2);
            }
            float radius = width / 2f;
            canvas.drawCircle(cx, cy, radius, paint);
        }
    }
}
