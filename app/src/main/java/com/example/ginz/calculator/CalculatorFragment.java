package com.example.ginz.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private float mFirstParam;
    private float mSecondParam;
    private String mOperation;
    private String mTemp = "";
    private EditText mEdtValue;
    private static final String ADD = "+";
    private static final String SUBSTRACT = "-";
    private static final String MULTIPLE = "*";
    private static final String DEVIDE = "/";
    private static final String POINT = ".";
    private static final String ZERO = "0";
    private static final String BLANK="";
    private static final Float DEFAULT_ZERO = 0.0f;
    public CalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculator, container,false);

        mEdtValue = v.findViewById(R.id.edtResult);

        int[] idButton = {R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6,
                R.id.button_7, R.id.button_8, R.id.button_9, R.id.button_delete, R.id.button_add, R.id.button_substract, R.id.button_multiple, R.id.button_devide, R.id.button_equal};

        for (int id:idButton){
            View view = (View) v.findViewById(id);
            view.setOnClickListener(this);
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add:
                mOperation = ADD;
                Operation();
                break;
            case R.id.button_substract:
                mOperation = SUBSTRACT;
                Operation();
                break;
            case R.id.button_multiple:
                mOperation = MULTIPLE;
                Operation();
                break;
            case R.id.button_devide:
                mOperation = DEVIDE;
                Operation();
                break;
            case R.id.button_equal:

                Float mResult = null;
                mSecondParam = Float.parseFloat(mEdtValue.getText().toString());
                if(mOperation == ADD){
                    mResult = mFirstParam + mSecondParam;
                }
                if(mOperation == SUBSTRACT){
                    mResult = mFirstParam - mSecondParam;
                }
                if(mOperation == MULTIPLE){
                    mResult = mFirstParam * mSecondParam;
                }
                if(mOperation == DEVIDE){
                    mResult = mFirstParam / mSecondParam;
                }

                mEdtValue.setText(String.valueOf(mResult));

                mFirstParam = DEFAULT_ZERO;
                mSecondParam = DEFAULT_ZERO;
                mTemp = ZERO;
                break;

            default:
                if(mTemp.equals(ZERO)){
                    mTemp = BLANK;
                }
                mTemp += ((Button)v).getText().toString();

                mEdtValue.setText(mTemp);
        }
    }

    private void Operation(){
        mFirstParam = Float.parseFloat(mEdtValue.getText().toString());
        mTemp = ZERO;
        mEdtValue.setText(ZERO);
    }
}
