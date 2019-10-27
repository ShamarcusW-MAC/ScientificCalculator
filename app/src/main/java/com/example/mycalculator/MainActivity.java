package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int DIVIDE = 0;
    private final int ADD = 1;
    private final int SUBTRACT = 2;
    private final int PERCENT = 3;
    private final int MULTIPLY = 4;
    private final int SQUARED = 5;
    private final int ROOT = 6;
    private final int SIN = 7;
    private final int COS = 8;
    private final int TAN = 9;
    private final int PI = 10;
    private final int FACT = 11;
    private final int EXP = 12;
    private final int CBRT = 13;
    private final int CUBIC = 14;
    private final int SIGN = 15;



    private TextView answerTextView;
    private TextView problemTextView;
    private double answerValue = 0.0f;
    private float firstValue = 0.0f;
    private float secondValue = 0.0f;
    private int operater = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextView = findViewById(R.id.main_textview);
        problemTextView = findViewById(R.id.problem_textview);
    }

    private void clearField(){
        answerTextView.setText("0");
        problemTextView.setText("");
        firstValue = 0f;
        secondValue = 0f;
        operater = 0;
        answerValue = 0f;
    }

    private void setOperater(int operater){
        this.operater = operater;
        firstValue = Float.parseFloat(answerTextView.getText().toString());
        answerTextView.setText("0");


        switch(operater){
            case PERCENT:
                answerValue = firstValue / 100;
                answerTextView.setText(answerValue + "");
                break;

            case SQUARED:
                answerValue = firstValue * firstValue;
                answerTextView.setText(answerValue + "");
                problemTextView.setText(firstValue + "²" + " = ");
                break;

            case ROOT:
                double answerValue = Math.sqrt(firstValue);
                answerTextView.setText(answerValue + "");
                problemTextView.setText("√" + firstValue + " = ");
                break;

            case SIN:
                double firstSin = Math.toRadians(firstValue);

                answerValue = Math.sin(firstSin);
                answerTextView.setText(answerValue + "");
                problemTextView.setText("sin(" + firstValue + ") = ");
                break;

            case COS:
                double firstCos = Math.toRadians(firstValue);

                answerValue = Math.cos(firstCos);
                answerTextView.setText(answerValue + "");
                problemTextView.setText("cos(" + firstValue + ") = ");

                break;

            case TAN:
                double firstTan = Math.toRadians(firstValue);

                answerValue = Math.tan(firstTan);
                answerTextView.setText(answerValue + "");
                problemTextView.setText("tan(" + firstValue + ") = ");

                break;

            case PI:
                double piValue = Math.PI;
                answerTextView.setText(piValue + "");
                break;

            case FACT:

                float factValue = 1;
                if (firstValue > 0){
                    for(int i = 2; i <= firstValue ; i++){
                        factValue = factValue * i;
                    }
                    answerTextView.setText(factValue + "");
                    problemTextView.setText(firstValue + "! =");
                }
                else if(firstValue < 0) {
                    answerTextView.setText("This is not a number!");
                    problemTextView.setText(firstValue + "! =");
                }
                else {
                    answerTextView.setText(firstValue + "");
                    problemTextView.setText(firstValue + "! =");
                }

                break;

            case CBRT:
                answerValue = Math.cbrt(firstValue);
                answerTextView.setText(answerValue + "");
                problemTextView.setText("³√" + firstValue + " = ");
                break;

            case CUBIC:
                answerValue = firstValue * firstValue * firstValue;
                answerTextView.setText(answerValue + "");
                problemTextView.setText(firstValue + "³ = ");

                break;

        }
    }

    private void changeSign(){
        if(!answerTextView.getText().toString().contains("-")) {
            answerTextView.setText("-" + answerTextView.getText().toString());
        }
        else{
            answerTextView.setText(answerTextView.getText().toString());
        }
    }

    private void calculate(){
        this.operater = operater;
        secondValue = Float.parseFloat(answerTextView.getText().toString());

        switch(operater){
            case ADD:
                answerValue = firstValue + secondValue;
                problemTextView.setText(firstValue + " + " + secondValue + " = ");
                break;

            case SUBTRACT:
                answerValue = firstValue - secondValue;
                problemTextView.setText(firstValue + " - " + secondValue + " = ");

                break;

            case DIVIDE:
                answerValue = firstValue / secondValue;
                problemTextView.setText(firstValue + " / " + secondValue + " = ");

                break;

            case MULTIPLY:
                answerValue = firstValue * secondValue;
                problemTextView.setText(firstValue + " * " + secondValue + " = ");

                break;
            case EXP:
                 answerValue = Math.pow(firstValue, secondValue);
                 problemTextView.setText(firstValue + "^" + secondValue + " = ");


        }
        answerTextView.setText(answerValue + "");

        //answerTextView.setText("0");
    }

    private void addNumber(int value){
        if(answerTextView.getText().equals("0"))
            answerTextView.setText("");

        if(!problemTextView.getText().equals("")) {
            answerTextView.setText("");
            problemTextView.setText("");
        }


        answerTextView.setText(answerTextView.getText().toString() + value);
    }

    private void addDecimal(){
        if(!answerTextView.getText().toString().contains("."))
            answerTextView.setText(answerTextView.getText().toString() + ".");

    }
    private void addPi(){
        if(answerTextView.getText().equals("0"))
            answerTextView.setText(Math.PI + "");

        if(!problemTextView.getText().equals("")) {
            answerTextView.setText(Math.PI + "");
            problemTextView.setText("");
        }
    }

    private void removeNumber(){
        if(answerTextView.getText().toString().trim().length() > 0 && !answerTextView.getText().toString().equals("0"))
            answerTextView.setText(answerTextView.getText().toString().substring(0, answerTextView.length() - 1));
    }

    public void onClick(View view) {
        switch(view.getId() ){
            case R.id.clear_button:
                clearField();

                break;


            case R.id.sign_button:

               changeSign();

               break;

            case R.id.add_button:

                setOperater(ADD);

                break;

            case R.id.subtract_button:

                setOperater(SUBTRACT);

                break;

            case R.id.zero_button:

                addNumber( 0);

                break;

            case R.id.one_button:

                addNumber( 1);


                break;

            case R.id.two_button:

                addNumber( 2);


                break;

            case R.id.three_button:

                addNumber( 3);


                break;

            case R.id.four_button:

                addNumber( 4);


                break;

            case R.id.five_button:

                addNumber( 5);


                break;

            case R.id.six_button:

                addNumber( 6);


                break;

            case R.id.seven_button:

                addNumber( 7);


                break;

            case R.id.eight_button:

                addNumber( 8);


                break;

            case R.id.nine_button:

                addNumber( 9);


                break;

            case R.id.pi_button:

                addPi();

                break;

            case R.id.percent_button:

                setOperater(PERCENT);

                break;

            case R.id.decimal_button:

                addDecimal();

                break;

            case R.id.equal_button:

                calculate();

                break;

            case R.id.back_button:

                removeNumber();

                break;

            case R.id.divide_button:

                setOperater(DIVIDE);

                break;

            case R.id.multiply_button:

                setOperater(MULTIPLY);

                break;

            case R.id.squared_button:

                setOperater(SQUARED);

                break;

            case R.id.sqrt_button:

                setOperater(ROOT);

                break;

            case R.id.sine_button:

                setOperater(SIN);

                break;

            case R.id.cos_button:

                setOperater(COS);

                break;

            case R.id.tan_button:

                setOperater(TAN);

                break;

            case R.id.fact_button:

                setOperater(FACT);

                break;

            case R.id.exp_button:

                setOperater(EXP);

                break;

            case R.id.cbrt_button:

                setOperater(CBRT);

                break;

            case R.id.cubic_button:

                setOperater(CUBIC);

                break;
        }
    }
}
