package com.example.user.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    public static final String LOAN_STATUS = "status";
    public static final String LOAN_MONTHLYPAY = "monthlyRepayment";
    EditText editTextPrice, editTextDownPayment, editTextInterestRate, editTextRepayment, editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LINK UI
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextDownPayment = (EditText) findViewById(R.id.editTextDownPayment);
        editTextInterestRate = (EditText) findViewById(R.id.editTextInterestRate);
        editTextRepayment = (EditText) findViewById(R.id.editTextRepayment);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
    }

    public void calculateLoan(View view)
    {
        //variables declaring
        double price, downPayment, interestRate, repayment, salary;
        double totalInterest, totalLoan, monthlyPayment;
        String status;

        //getting input value from respective fields
        price = Double.parseDouble(editTextPrice.getText().toString());
        downPayment = Double.parseDouble(editTextDownPayment.getText().toString());
        interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        repayment = Double.parseDouble(editTextRepayment.getText().toString());
        salary = Double.parseDouble(editTextSalary.getText().toString());

        //calculationssssssss
        totalInterest = (price - downPayment) * (interestRate / 100) * (repayment / 12);
        totalLoan = (price - downPayment) + totalInterest;
        monthlyPayment = totalLoan / repayment;

        //if monthlyPayment > 30% of salary
        if (monthlyPayment > (salary * 30 / 100))
            status = "Reject";
        else
            status = "Accept";

        //transition to result activity
        Intent intent = new Intent(this, ResultActivity.class);
        //putExtra function has two para, (Tag, Value). NOTE: tag name must be unique
        intent.putExtra(LOAN_STATUS, status);
        intent.putExtra(LOAN_MONTHLYPAY, monthlyPayment);
        startActivity(intent);
    }

}
