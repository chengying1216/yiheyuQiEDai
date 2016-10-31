package com.yiheyu.qiedai.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.yiheyu.qiedai.R;
import com.yiheyu.qiedai.controller.BackHandlerInterface;
import com.yiheyu.qiedai.view.fragment.ActivityFragment;
import com.yiheyu.qiedai.view.fragment.BackHandlerFragment;
import com.yiheyu.qiedai.view.fragment.HomeFragment;
import com.yiheyu.qiedai.view.fragment.MyFragment;
import com.yiheyu.qiedai.view.fragment.ThrowOrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BackHandlerInterface {

    @BindView(R.id.tv_home)
    TextView tv_home;//首页
    @BindView(R.id.tv_throw_order)
    TextView tv_throw_order;//甩单
    @BindView(R.id.tv_activity)
    TextView tv_activity;//活动
    @BindView(R.id.tv_my)
    TextView tv_my;//我

    private BackHandlerFragment mBackHandedFragment;

    public static MainActivity mainactivity = null;

    private int tab = 0;

    private HomeFragment homeFragment;
    private ThrowOrderFragment throwOrderFragment;
    private ActivityFragment activityFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTabSelection(0);
    }

    @OnClick({ R.id.tv_home, R.id.tv_throw_order, R.id.tv_activity, R.id.tv_my})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.tv_home:
                setTabSelection(0);
                break;
            case R.id.tv_throw_order:
                setTabSelection(1);
                break;
            case R.id.tv_activity:
                setTabSelection(2);
                break;
            case R.id.tv_my:
                setTabSelection(3);
                break;
          
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                tv_home.setSelected(true);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                transaction.commit();
                break;
            case 1:
                tv_throw_order.setSelected(true);
                if (throwOrderFragment == null) {
                    throwOrderFragment = new ThrowOrderFragment();
                    transaction.add(R.id.content, throwOrderFragment);
                } else {
                    transaction.show(throwOrderFragment);
                }
                transaction.commit();
                break;
            case 2:
                tv_activity.setSelected(true);
                if (activityFragment == null) {
                    activityFragment = new ActivityFragment();
                    transaction.add(R.id.content, activityFragment);
                } else {
                    transaction.show(activityFragment);
                }
                transaction.commit();
                break;
            case 3:
                tv_my.setSelected(true);
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.content, myFragment);
                } else {
                    transaction.show(myFragment);
                }
                transaction.commit();
//                EventBus.getDefault().post(new MsgEvent(2333));
                break;
           
        }
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {

        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (throwOrderFragment != null) {
            transaction.hide(throwOrderFragment);
        }
        if (activityFragment != null) {
            transaction.hide(activityFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        tv_home.setSelected(false);
        tv_throw_order.setSelected(false);
        tv_activity.setSelected(false);
        tv_my.setSelected(false);
    }


    public void setSelectedFragment(BackHandlerFragment selectedFragment) {
        this.mBackHandedFragment = selectedFragment;
    }


    @Override
    public void onBackPressed() {
        if (mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        }
    }

}
