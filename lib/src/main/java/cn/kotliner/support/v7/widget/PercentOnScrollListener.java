package cn.kotliner.support.v7.widget;

import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * The basic scroll listener, used to convert {@link #onScrolled(RecyclerView, int, int)} to {@link #onScrolled(View, float)}
 * Only works on LinearLayoutManager.
 *
 * @author DengChao on 2017/8/26. qq235690622@gmail.com
 */
public abstract class PercentOnScrollListener extends RecyclerView.OnScrollListener {

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int first = layoutManager.findFirstVisibleItemPosition();
        int last = layoutManager.findLastVisibleItemPosition();
        View view;//each itemView
        if (layoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
            int height = recyclerView.getHeight();
            float centerV;//each itemView's vertical center
            for (int i = first; i <= last; i++) {
                view = layoutManager.findViewByPosition(i);
                centerV = view.getTop() + view.getHeight() / 2;
                onScrolled(view, centerV / height);
            }
        } else {
            int width = recyclerView.getWidth();
            float centerH;//each itemView's horizontal center
            for (int i = first; i <= last; i++) {
                view = layoutManager.findViewByPosition(i);
                centerH = view.getLeft() + view.getWidth() / 2;
                onScrolled(view, centerH / width);
            }
        }
    }

    /**
     * Called when the recyclerView is scrolled.
     * Since we don't care about how much pixel the recyclerView is scrolled,
     * so we focus on each itemView's position.
     *
     * @param view    current itemView
     * @param percent current itemView's position percent ,form top to bottom, or left to right,
     *                in [0-x,1+x], x depend on your itemView and recyclerView's width or height.
     */
    protected abstract void onScrolled(@NonNull View view, @FloatRange(from = 0, to = 1) float percent);
}
