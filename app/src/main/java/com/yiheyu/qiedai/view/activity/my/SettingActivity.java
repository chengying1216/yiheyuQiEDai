package com.yiheyu.qiedai.view.activity.my;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yiheyu.qiedai.R;
import com.yiheyu.qiedai.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.rl_setting_msg)
    RelativeLayout rl_setting_msg;
    @BindView(R.id.rl_setting_modify_psw)
    RelativeLayout rl_setting_modify_psw;
    @BindView(R.id.rl_setting_soft_update)
    RelativeLayout rl_setting_soft_update;
    @BindView(R.id.rl_setting_suggestion)
    RelativeLayout rl_setting_suggestion;
    @BindView(R.id.rl_setting_clear_the_cache)
    RelativeLayout rl_setting_clear_the_cache;
    @BindView(R.id.rl_setting_about)
    RelativeLayout rl_setting_about;
    @BindView(R.id.rl_setting_graded)
    RelativeLayout rl_setting_graded;
    @BindView(R.id.rl_setting_service_tel)
    RelativeLayout rl_setting_service_tel;

    private static final int CALL_PHONE_REQUEST_CODE = 1;


    @OnClick({R.id.btn_back, R.id.rl_setting_msg, R.id.rl_setting_modify_psw, R.id.rl_setting_soft_update, R.id.rl_setting_suggestion
            , R.id.rl_setting_clear_the_cache, R.id.rl_setting_about, R.id.rl_setting_graded, R.id.rl_setting_service_tel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.rl_setting_msg:
                startActivity(new Intent(this,MessageActivity.class));
                break;
            case R.id.rl_setting_modify_psw:
                startActivity(new Intent(this,ModifyPswActivity.class));
                break;
            case R.id.rl_setting_soft_update:
                // 软件更新
//                startActivity(new Intent(this,SoftUpdateActivity.class));
                break;
            case R.id.rl_setting_suggestion:
                startActivity(new Intent(this,SuggestionActivity.class));
                break;
            case R.id.rl_setting_clear_the_cache:
                //  清理缓存
//                startActivity(new Intent(this,CleanCacheActivity.class));
                break;
            case R.id.rl_setting_about:
                startActivity(new Intent(this,AboutActivity.class));
                break;
            case R.id.rl_setting_graded:
                //  到应用市场评分
//                startActivity(new Intent(this,GradedActivity.class));
                break;
            case R.id.rl_setting_service_tel:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View v = getLayoutInflater().inflate(R.layout.view_dialog_service_call, null);
                builder.setView(v);
                TextView tvno = (TextView) v.findViewById(R.id.tv_no);
                TextView tvyes = (TextView) v.findViewById(R.id.tv_yes);
                final Dialog dialog = builder.create();
                tvno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tvyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (ContextCompat.checkSelfPermission(SettingActivity.this, Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED) {
                            //申请WRITE_EXTERNAL_STORAGE权限
                            ActivityCompat.requestPermissions(SettingActivity.this,new String[]{Manifest.permission.CALL_PHONE},
                                    CALL_PHONE_REQUEST_CODE);
                        }else {
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:4001001111"));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    }
                });

                dialog.show();


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

}
