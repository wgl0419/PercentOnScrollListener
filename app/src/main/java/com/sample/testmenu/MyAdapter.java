package com.sample.testmenu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author DengChao on 2017/8/26. qq235690622@gmail.com
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private int[] colors = new int[]{
            R.color.c1, R.color.c2,
            R.color.c3, R.color.c4,
            R.color.c5, R.color.c6,
            R.color.c7
    };

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (holder != null) {
            holder.textView.setBackgroundResource(colors[position % colors.length]);
        }
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        final TextView textView;

        private MyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_root);
        }
    }
}
