package com.yiheyu.qiedai.view.activity.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.yiheyu.qiedai.R;
import com.yiheyu.qiedai.view.activity.BaseActivity;
import com.yiheyu.qiedai.view.activity.ForgetPswActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModifyPswActivity extends BaseActivity {

    @BindView(R.id.et_old_psw)
    EditText et_old_psw;//原始密码
    @BindView(R.id.et_new_psw)
    EditText et_new_psw;//新密码
    @BindView(R.id.et_new_psw_re)
    EditText et_new_psw_re;

    @OnClick({R.id.btn_back, R.id.tv_forget_psw, R.id.btn_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.tv_forget_psw:
                startActivity(new Intent(this, ForgetPswActivity.class));
                break;
            case R.id.btn_sure:
                //  上传修改信息
                finish();
                break;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_psw);
        ButterKnife.bind(this);
    }
}
