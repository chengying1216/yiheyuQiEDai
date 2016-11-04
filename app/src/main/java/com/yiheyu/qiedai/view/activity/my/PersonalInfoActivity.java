package com.yiheyu.qiedai.view.activity.my;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yiheyu.qiedai.R;
import com.yiheyu.qiedai.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalInfoActivity extends BaseActivity {


    @BindView(R.id.et_info_self_introduction)
    EditText et_info_self_introduction;
    @BindView(R.id.tv_info_name)
    TextView tv_info_name;
    @BindView(R.id.tv_info_age)
    TextView tv_info_age;
    @BindView(R.id.tv_info_company)
    TextView tv_info_company;
    @BindView(R.id.tv_info_address)
    TextView tv_info_address;
    @BindView(R.id.tv_info_business)
    TextView tv_info_business;
    @BindView(R.id.tv_info_working_time)
    TextView tv_info_working_time;



    private  View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = getLayoutInflater().inflate(
                R.layout.activity_personal_info, null);

        setContentView(view);
        ButterKnife.bind(this);
        et_info_self_introduction.setFocusable(false);
    }



    @OnClick({R.id.btn_back,R.id.iv_name, R.id.tv_info_name,R.id.tv_info_sex, R.id.iv_sex, R.id.tv_info_smarital_statu, R.id.iv_smarital_statu, R.id.iv_age,
            R.id.tv_info_age, R.id.tv_info_phone, R.id.tv_info_id, R.id.tv_info_company, R.id.iv_company, R.id.tv_info_address, R.id.iv_address, R.id.iv_business,
            R.id.tv_info_business, R.id.tv_info_working_time, R.id.iv_working_time,R.id.et_info_self_introduction})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.iv_name:
            case R.id.tv_info_name:
                EditInfo("输入姓名",tv_info_name);
                break;
            case R.id.tv_info_sex:
            case R.id.iv_sex:

                List<String> data = new ArrayList<>();
                data.add("女");
                data.add("男");
//                select(data);
                View contentView = LayoutInflater.from(this).inflate(R.layout.view_popupwindow_person_info, null);
                ListView lv = (ListView) contentView.findViewById(R.id.lv_select);
                Lvadapter lvAdapter = new Lvadapter(data);
                lv.setAdapter(lvAdapter);
                PopupWindow pop  = new PopupWindow(contentView);
                int width = context.getResources().getDisplayMetrics().widthPixels;
                int height = context.getResources().getDisplayMetrics().heightPixels;
                pop.setContentView(contentView);
                // 设置SelectPicPopupWindow弹出窗体的宽
                pop.setWidth(width);
                // 设置SelectPicPopupWindow弹出窗体的高
                pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                // 设置SelectPicPopupWindow弹出窗体可点击
                pop.setFocusable(true);
                pop.setOutsideTouchable(true);
                // 刷新状态
                pop.update();
                // 实例化一个ColorDrawable颜色为半透明
                ColorDrawable dw = new ColorDrawable(0000000000);
                // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
                pop.setBackgroundDrawable(dw);
                // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
                // 设置SelectPicPopupWindow弹出窗体动画效果
//                pop.setAnimationStyle(R.style.AnimationPreview);
                //设置各个控件的点击响应
                //显示PopupWindow
                pop.showAtLocation(view, Gravity.BOTTOM,0,0);

                break;
            case R.id.tv_info_smarital_statu:
            case R.id.iv_smarital_statu:
                break;
            case R.id.iv_age:
            case R.id.tv_info_age:
                EditInfo("输入年龄",tv_info_age);
                break;
            case R.id.tv_info_phone:
                break;
            case R.id.tv_info_id:
                break;
            case R.id.iv_company:
            case R.id.tv_info_company:
                EditInfo("输入公司",tv_info_company);
                break;
            case R.id.iv_address:
            case R.id.tv_info_address:
                EditInfo("输入地址",tv_info_address);
                break;
            case R.id.iv_business:
            case R.id.tv_info_business:
                EditInfo("业务范围",tv_info_business);
                break;
            case R.id.tv_info_working_time:
            case R.id.iv_working_time:
                EditInfo("工作年限",tv_info_working_time);
                break;
//            case R.id.et_info_self_introduction:
//                et_info_self_introduction.setFocusable(true);
//                break;
        }
    }

    private void select(String title,List<String> data,TextView tv) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View v = getLayoutInflater().inflate(R.layout.view_popupwindow_person_info, null);
        builder.setView(v);
        TextView tvtitle = (TextView) v.findViewById(R.id.tv_title);
        tvtitle.setText(title);
        TextView tvno = (TextView) v.findViewById(R.id.tv_no);
        TextView tvyes = (TextView) v.findViewById(R.id.tv_yes);
        ListView lv = (ListView) v.findViewById(R.id.lv_select);
        Lvadapter lvAdapter = new Lvadapter(data);
        lv.setAdapter(lvAdapter);
       lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
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
//                tv.setText();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void EditInfo(String hint, final TextView tv_info) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View v = getLayoutInflater().inflate(R.layout.view_edit_someting, null);
        builder.setView(v);
        TextView tvno = (TextView) v.findViewById(R.id.tv_no);
        TextView tvyes = (TextView) v.findViewById(R.id.tv_yes);
        final EditText editinfo = (EditText) v.findViewById(R.id.edit_info);
        editinfo.setHint(hint);
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
                String txt = editinfo.getText().toString();
                tv_info.setText(txt);
                dialog.dismiss();
            }
        });
        dialog.show();
    }




   class Lvadapter extends BaseAdapter{

       private List<String> data;

       public Lvadapter(List<String> data) {
           this.data = data;
       }

       @Override
       public int getCount() {
           return data.size();
       }

       @Override
       public Object getItem(int i) {
           return data.get(i);
       }

       @Override
       public long getItemId(int i) {
           return i;
       }

       @Override
       public View getView(int i, View view, ViewGroup viewGroup) {
           view = LayoutInflater.from(context).inflate(R.layout.item_textview, null);
           TextView tv_txt = (TextView) view.findViewById(R.id.tv_txt);
           tv_txt.setText(data.get(i).toString());

           return view;
       }
   }
}
