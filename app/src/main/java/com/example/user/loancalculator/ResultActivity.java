package com.example.user.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity
{
    TextView textViewMonthlyPayment, textViewStatusResult;
    String status;
    double monthlyRepayment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //LINK UI
        textViewMonthlyPayment = (TextView) findViewById(R.id.textViewMonthlyRepayment);
        textViewStatusResult = (TextView) findViewById(R.id.textViewStatus);

        //Get extra value from main activity
        //getIntent() function = asking "who called me?"
        Intent intent = getIntent();
        status = intent.getStringExtra(MainActivity.LOAN_STATUS);
        monthlyRepayment = intent.getDoubleExtra(MainActivity.LOAN_MONTHLYPAY, 0); //for getting extra numerical data, a default value must be provided

        //display results
        textViewMonthlyPayment.setText("Monthly Repayment = " + monthlyRepayment);
        textViewStatusResult.setText("Status : " + status);
    }

    public void closeActivity(View view)
    {
        finish();
    }
}
