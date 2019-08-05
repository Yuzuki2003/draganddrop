package com.minami.draganddrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener{

    private  CustomImageView cImageView;
    private int preDx, preDy;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        cImageView = this.findViewById(R.id.image_view);
        cImageView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // x,y 位置取得
        int newDx = (int)event.getRawX();
        int newDy = (int)event.getRawY();

        switch (event.getAction()) {
            // タッチダウンでdragされた
            case MotionEvent.ACTION_MOVE:
                // ACTION_MOVEでの位置
                // performCheckを入れろと警告が出るので
                v.performClick();
                int dx = cImageView.getLeft() + (newDx - preDx);
                int dy = cImageView.getTop() + (newDy - preDy);
                int imgW = dx + cImageView.getWidth();
                int imgH = dy + cImageView.getHeight();

                // 画像の位置を設定する
                cImageView.layout(dx, dy, imgW, imgH);

                String str = "dx="+dx+"\ndy="+dy;
                textView.setText(str);
                Log.d("onTouch","ACTION_MOVE: dx="+dx+", dy="+dy);
                break;
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        // タッチした位置を古い位置とする
        preDx = newDx;
        preDy = newDy;

        return true;
    }
}
