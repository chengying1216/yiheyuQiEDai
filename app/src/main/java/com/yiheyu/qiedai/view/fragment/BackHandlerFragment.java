package com.yiheyu.qiedai.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.yiheyu.qiedai.controller.BackHandlerInterface;


public abstract class BackHandlerFragment extends Fragment {

    protected BackHandlerInterface mBackHandledInterface;

    public abstract boolean onBackPressed();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof BackHandlerInterface)) {
            throw new ClassCastException("Hosting Activity must implement BackHandledInterface");
        } else {
            this.mBackHandledInterface = (BackHandlerInterface) getActivity();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // 告诉FragmentActivity，当前Fragment在栈顶
        mBackHandledInterface.setSelectedFragment(this);
    }
}
