package com.example.firsttrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textView;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operator, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button buttonApply = findViewById(R.id.equal);

        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText num1= findViewById(R.id.firstnum);
                EditText num2 = findViewById(R.id.secondnum);
                textView=findViewById(R.id.hasil);

                double number1=0;
                double number2=0;
                if(num1.getText().toString().isEmpty())
                {
                    number1=0;
                }
                else
                {
                    number1= Double.parseDouble(num1.getText().toString());
                }

                if(num2.getText().toString().isEmpty())
                {
                    number2=0;
                }
                else
                {
                    number2= Double.parseDouble(num2.getText().toString());
                }

                double result=0;

                if(text.equals("+"))
                {
                    result = number1+number2;
                }
                else if(text.equals("-"))
                {
                    result = number1-number2;
                }
                else if(text.equals("x"))
                {
                    result = number1*number2;
                }
                else if(text.equals("/"))
                {
                    result = number1/number2;
                }

                textView.setText(result+"");
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text= adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
