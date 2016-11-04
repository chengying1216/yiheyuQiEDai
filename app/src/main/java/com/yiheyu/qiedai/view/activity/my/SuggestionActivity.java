package com.yiheyu.qiedai.view.activity.my;

import android.os.Bundle;
import android.view.View;

import com.yiheyu.qiedai.R;
import com.yiheyu.qiedai.view.activity.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuggestionActivity extends BaseActivity {



    @OnClick({R.id.btn_back,R.id.btn_submit})
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_submit:
                //  上传
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        ButterKnife.bind(this);
    }
}
