package com.jongzazaal.sampletool;

import android.view.View;

/**
 * Created by jongzazaal on 2/10/2559.
 */

public interface ItemClickListener {
    void onClick(View view, int position, boolean isLongClick);
}