package cn.kotliner.support.v7.widget;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * The scale implement.
 *
 * @author DengChao on 2017/8/26. qq235690622@gmail.com
 */
@SuppressWarnings("WeakerAccess")
public class ScaleOnScrollListener extends PercentOnScrollListener {
    private float scaleX;
    private float scaleY;
    private float centerX;
    private float centerY;

    /**
     * 同时缩放ItemView的宽与高
     * 缩放效果: 中间正常宽高; 两边宽高 * 0.8
     * <p>
     * The center itemView's width *= 1
     * The center itemView's height *= 1
     * The left and right, or top and bottom itemViews's width *= 0.75
     * The left and right, or top and bottom itemViews's height *= 0.75
     */
    public ScaleOnScrollListener() {
        this(0.75F);
    }

    /**
     * 同时缩放ItemView的宽与高
     * 缩放效果: 中间正常宽高; 两边宽高 * scale
     * <p>
     * The center itemView's width *= 1
     * The center itemView's height *= 1
     * The left and right, or top and bottom itemViews's width *= scale
     * The left and right, or top and bottom itemViews's height *= scale
     */
    public ScaleOnScrollListener(float scale) {
        this(scale, scale);
    }

    /**
     * 同时缩放ItemView的宽与高
     * 缩放效果: 中间正常宽高; 两边宽 * scaleX, 高 * scaleY
     * <p>
     * The center itemView's width *= 1
     * The center itemView's height *= 1
     * The left and right, or top and bottom itemViews's width *= scaleX
     * The left and right, or top and bottom itemViews's height *= scaleY
     */
    public ScaleOnScrollListener(float scaleX, float scaleY) {
        this(1, 1, scaleX, scaleY);
    }

    /**
     * 同时缩放ItemView的宽与高
     * 缩放效果: 中间宽 * centerX,高 *centerY; 两边宽 * scaleX, 高 * scaleY
     * <p>
     * The center itemView's width *= centerX
     * The center itemView's height *= centerY
     * The left and right, or top and bottom itemViews's width *= scaleX
     * The left and right, or top and bottom itemViews's height *= scaleY
     */
    public ScaleOnScrollListener(float centerX, float centerY, float scaleX, float scaleY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    protected void onScrolled(@NonNull View view, float percent) {
        if (percent > 0.5) {
            percent = 1 - percent;
        }
        view.setScaleX(percent * 2 * (centerX - scaleX) + scaleX);
        view.setScaleY(percent * 2 * (centerY - scaleY) + scaleY);
    }
}
