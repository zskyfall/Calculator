package com.example.ginz.calculator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(new CalculatorFragment());
    }

    private void addFragment(Fragment fragment){
        FragmentManager mFragmentManager = getSupportFragmentManager();

        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        mTransaction.add(fragment,"");
        mTransaction.commit();
    }

    @Override
    public void onClick(View view) {

    }
}
