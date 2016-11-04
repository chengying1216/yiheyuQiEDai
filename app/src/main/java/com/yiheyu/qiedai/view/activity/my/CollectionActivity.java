package com.yiheyu.qiedai.view.activity.my;

import android.os.Bundle;
import android.view.View;

import com.yiheyu.qiedai.R;
import com.yiheyu.qiedai.view.activity.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionActivity extends BaseActivity {

    @OnClick({R.id.btn_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_back:
                finish();
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ButterKnife.bind(this);
    }
}
