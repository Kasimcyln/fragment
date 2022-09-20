package com.kasimkartal866.fragment3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnFragA, btnFragB, btnAct2, btnSendData;
    private EditText etName, mobileEdit;
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        bindViews();
        setClickListeners();
    }

    private void bindViews() {
        etName = findViewById(R.id.etName);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragA = findViewById(R.id.btnFragA);
        btnAct2 = findViewById(R.id.btnAct2);
        btnSendData = findViewById(R.id.btnSendData);
    }

    private void setClickListeners() {
        btnFragA.setOnClickListener(this);
        btnFragB.setOnClickListener(this);
        btnAct2.setOnClickListener(this);
        btnSendData.setOnClickListener(this);
    }

    private void  openFragment(ISetData fragment) {
        if (fragment == null) {
            if (fragment instanceof FragmentA)
                fragment = FragmentA.getInstance();
            else if (fragment instanceof FragmentB)
                fragment = new FragmentB();
        }
        List<Fragment> mList = getSupportFragmentManager().getFragments();
        if (mList.contains(fragment)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, (Fragment) fragment)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, (Fragment)fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Close app")
                    .setMessage("Are you sure?")
                    .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                    .setPositiveButton("Yes", (dialog, which) -> super.onBackPressed())
                    .create();
            builder.show();
        }
    }

    private void sendData(String data) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null) {
            if (fragment instanceof FragmentA) {
                ((FragmentA) fragment).setData(data);

            }
            if (fragment instanceof FragmentB) {
                ((FragmentB) fragment).setData(data);
            }
        }

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAct2:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.btnFragA:
                openFragment(FragmentA.getInstance());
                break;
            case R.id.btnFragB:
                openFragment(FragmentB.getInstance());
                break;
            case R.id.btnSendData:
                sendData(etName.getText().toString());
                break;
        }
    }
}