package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    private String current_operand = "None";
    private double first_input = 0.0;
    private boolean end_compute = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        TextView output = findViewById((R.id.output));
        output.setText("0");
    }

    public void ButtonInput(View button){
        String number = ((Button) button).getText().toString();
        TextView output = findViewById(R.id.output);
        String currentoutput = output.getText().toString();
        if(currentoutput.equals("0") || end_compute == true){
            output.setText(number);
        }
        else{
            String newoutput = currentoutput + number;
            output.setText(newoutput);
        }
        end_compute = false;
    }

    public void Clear(View button){
        TextView output = findViewById(R.id.output);
        output.setText("0");
        current_operand = "None";
        first_input = 0.0;
        end_compute = false;
    }

    public void Addition(View button){
        Equals(button);
        end_compute = false;
        TextView output = findViewById(R.id.output);
        first_input = Double.parseDouble(output.getText().toString());
        output.setText("0");
        current_operand = "Addition";
    }

    public void Subtraction(View button){
        Equals(button);
        end_compute = false;
        TextView output = findViewById(R.id.output);
        first_input = Double.parseDouble(output.getText().toString());
        output.setText("0");
        current_operand = "Subtraction";
    }

    public void Multiplication(View button){
        Equals(button);
        end_compute = false;
        TextView output = findViewById(R.id.output);
        first_input = Double.parseDouble(output.getText().toString());
        output.setText("0");
        current_operand = "Multiplication";
    }

    public void Division(View button){
        Equals(button);
        end_compute = false;
        TextView output = findViewById(R.id.output);
        first_input = Double.parseDouble(output.getText().toString());
        output.setText("0");
        current_operand = "Division";
    }

    public void Equals(View button){
        TextView output = findViewById(R.id.output);
        double second_input = Double.parseDouble(output.getText().toString());
        double answer = 0.0;
        switch (current_operand) {
            case "Addition":
                answer = first_input + second_input;
                break;
            case "Subtraction":
                answer = first_input - second_input;
                break;
            case "Multiplication":
                answer = first_input * second_input;
                break;
            case "Division":
                answer = first_input / second_input;
                break;
            case "None":
                answer = second_input;
                break;
        }
        current_operand = "None";
        end_compute = true;
        output.setText(Double.toString(answer));
    }
}