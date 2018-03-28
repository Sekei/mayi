package com.mayi.video.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by admin on 2018/3/28.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;
        if (parent.getChildAdapterPosition(view) != 0 && parent.getChildAdapterPosition(view) != 1) {
            outRect.top = mSpace;
        }
    }

    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }
}
