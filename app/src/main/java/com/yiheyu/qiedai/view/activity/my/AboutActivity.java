package com.yiheyu.qiedai.view.activity.my;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yiheyu.qiedai.R;
import com.yiheyu.qiedai.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.tv_introduction)
    TextView tv_introduction;

    @BindView(R.id.iv_down)
    ImageView iv_down;

    boolean flag = true;
    @OnClick({R.id.btn_back, R.id.btn_share, R.id.tv_introduction,R.id.iv_down})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_share:
//                 分享
                break;
            case R.id.tv_introduction:
                if(flag){
                    flag = false;
                    tv_introduction.setEllipsize(null); // 展开
                    tv_introduction.setSingleLine(flag);
                    iv_down.setVisibility(View.GONE);
                }else{
                    flag = true;
                    tv_introduction.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                }
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
    }
}
