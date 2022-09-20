package com.kasimkartal866.fragment3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentA extends Fragment implements ISetData {
    private static FragmentA instance;
    TextView tvMessage;
    View view;

    public static FragmentA getInstance() {
        if (instance == null)
            instance = new FragmentA();
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_a, container, false);



        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvMessage = view.findViewById(R.id.tvMessage);

    }

    @Override
    public void setData(String data) {
        tvMessage.setText(data);
    }

}