package com.geek.notchtools;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import notchtools.geek.com.notchtools.NotchTools;
import notchtools.geek.com.notchtools.core.NotchProperty;
import notchtools.geek.com.notchtools.core.OnNotchCallBack;

public class FullScreenUseNotchActivity extends BaseActivity implements OnNotchCallBack {

    private ImageView mBackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_use_notch);
        mBackView = findViewById(R.id.img_back);
        mBackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        NotchTools.getFullScreenTools().fullScreenUseStatusForActivityOnCreate(this, this);
    }

    @Override
    public void onNotchPropertyCallback(NotchProperty notchProperty) {
        int marginTop = notchProperty.getMarginTop();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mBackView.getLayoutParams();
        layoutParams.topMargin += marginTop;
        mBackView.setLayoutParams(layoutParams);
    }

    /**
     * onWindowFocusChanged鏈€濂戒篃杩涜鍏ㄥ睆閫傞厤锛岄槻姝㈠け鍘荤劍鐐瑰張閲嶅洖鐒︾偣鏃剁殑flag涓嶆纭€?     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            NotchTools.getFullScreenTools().fullScreenUseStatusForOnWindowFocusChanged(this);
        }
        super.onWindowFocusChanged(hasFocus);
    }
}

