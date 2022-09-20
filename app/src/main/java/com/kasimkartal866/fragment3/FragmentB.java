package com.kasimkartal866.fragment3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment  implements ISetData {
    TextView tvMessage2;
    View mContext;
    private static FragmentB instance;

    public FragmentB() {
    }

    public static FragmentB getInstance() {
        if (instance == null)
            instance = new FragmentB();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext =  inflater.inflate(R.layout.fragment_b, container, false);

        tvMessage2 = mContext.findViewById(R.id.tvMessage2);


        return  mContext;
    }

    @Override
    public void setData(String data) {
        tvMessage2.setText(data);
    }
}