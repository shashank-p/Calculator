package com.shashank.addition;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    TextView addResult;
    Button btnAdd,btnSub,btnMul,btnDiv,btnClr;

    double num1,num2,sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText)findViewById(R.id.txtNumber1);
        secondNumber = (EditText)findViewById(R.id.txtNumber2);
        addResult = (TextView)findViewById(R.id.txtResult);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnClr = (Button)findViewById(R.id.btnClr);

        firstNumber.setText("0");
        secondNumber.setText("0");

        btnAdd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                hideKeyboard(MainActivity.this);
                num1 = Double.parseDouble(firstNumber.getText().toString());
                num2 = Double.parseDouble(secondNumber.getText().toString());
                sum = num1 + num2;
                addResult.setText(Double.toString(sum));
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                hideKeyboard(MainActivity.this);
                num1 = Double.parseDouble(firstNumber.getText().toString());
                num2 = Double.parseDouble(secondNumber.getText().toString());
                sum = num1 - num2;
                addResult.setText(Double.toString(sum));
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                hideKeyboard(MainActivity.this);
                num1 = Double.parseDouble(firstNumber.getText().toString());
                num2 = Double.parseDouble(secondNumber.getText().toString());
                sum = num1 * num2;
                addResult.setText(Double.toString(sum));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                hideKeyboard(MainActivity.this);
                num1 = Double.parseDouble(firstNumber.getText().toString());
                num2 = Double.parseDouble(secondNumber.getText().toString());
                sum = num1 / num2;
                sum = Math.floor(sum * 100) / 100;
                addResult.setText(Double.toString(sum));
            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                firstNumber.setText("0");
                secondNumber.setText("0");
                addResult.setText(" ");
            }
        });

    }

    public static void hideKeyboard( Activity activity ) {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService( Context.INPUT_METHOD_SERVICE );
        View f = activity.getCurrentFocus();
        if( null != f && null != f.getWindowToken() && EditText.class.isAssignableFrom( f.getClass() ) )
            imm.hideSoftInputFromWindow( f.getWindowToken(), 0 );
        else
            activity.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN );
    }

}
