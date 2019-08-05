package com.minami.draganddrop;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import java.util.jar.Attributes;

public class CustomImageView extends AppCompatImageView {

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }
}
