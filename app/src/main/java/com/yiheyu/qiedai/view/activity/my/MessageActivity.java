package com.yiheyu.qiedai.view.activity.my;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.yiheyu.qiedai.R;
import com.yiheyu.qiedai.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity {


    @BindView(R.id.linear_message_setting)
    LinearLayout linear_message_setting;
    @BindView(R.id.cx_message)
    CheckBox cx_message;
    @BindView(R.id.cx_order_receiving)
    CheckBox cx_order_receiving;
    @BindView(R.id.cx_progress)
    CheckBox cx_progress;
    @BindView(R.id.cx_system_msg)
    CheckBox cx_system_msg;


    @OnClick({R.id.btn_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);

        cx_message.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    linear_message_setting.setVisibility(View.VISIBLE);
                }else {
                    linear_message_setting.setVisibility(View.GONE);
                }
            }
        });
    }
}
