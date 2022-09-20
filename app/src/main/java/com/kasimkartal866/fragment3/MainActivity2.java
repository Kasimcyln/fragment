package com.kasimkartal866.fragment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity {

    private Button btnChange;
    int kontrol = 0;
    FragmentA fragmentA = new FragmentA();
    FragmentB fragmentB = new FragmentB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnChange = findViewById(R.id.btnChange);

        degistirFragment(new FragmentA(),R.id.fragment1,false,fragmentA.getTag());
        degistirFragment(new FragmentB(),R.id.fragment2,false,fragmentB.getTag());

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (kontrol) {
                    case 0 :
                        degistirFragment(new FragmentA(),R.id.fragment1,false,fragmentA.getTag());
                        degistirFragment(new FragmentB(),R.id.fragment2,false,fragmentB.getTag());
                        kontrol = 1;
                    case 1 :
                        degistirFragment(new FragmentB(),R.id.fragment1,false,fragmentB.getTag());
                        degistirFragment(new FragmentA(),R.id.fragment2,false,fragmentA.getTag());
                        kontrol = 0;
                        break;
                    default:
                        break;
                }
            }
        });
    }
    protected void degistirFragment (Fragment fragment ,int container_id, boolean addToBackStack, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(container_id,fragment,tag);
        if(addToBackStack) {
            ft.addToBackStack(tag) ;
        }
        ft.commit();
    }
}