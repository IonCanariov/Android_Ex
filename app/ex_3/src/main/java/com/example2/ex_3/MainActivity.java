package com.example2.ex_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private TextView calculator,resultTextView;
private EditText number1,number2,editText;

private ImageButton resultButton;
private Button button_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.textField);
        resultTextView = findViewById(R.id.resultView);
        number1 = findViewById(R.id.firstNumber);
        number2 = findViewById(R.id.secondNumber);
        resultButton  = findViewById(R.id.resultButton);
        button_second = findViewById(R.id.secondButton);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(number1.getText().toString());/*parseInt or parseFloat changes data from a line of characters to a int number or float number... */
                int num2 = Integer.parseInt(number2.getText().toString());
                int result = num1+num2;

                resultTextView.setText(String.valueOf(result));
            }
        });
    }
    public void onFirstButtonClicked(View v){
        setContentView(R.layout.first_view);
        showInfo(((Button) v).getText().toString(),((Button) v));
    }
    public void goBack(View v){
        setContentView(R.layout.activity_main);

    }
    public void onSecondButtonClicked(View v){
        button_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
       //         showInfo(((Button) v).getText().toString(),((Button) v));
                showAlert("Do u really want to do this?");
            }
        });
    }
    public void onThirdButtonClicked(View v){
     showInfo(editText.getText().toString(),((Button) v));
    }

    private void showAlert(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("help")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("switch of", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       setContentView(R.layout.first_view);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void showInfo(String text, Button btn){
       // btn.setText("something new");
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
                //context shows where the toast will be displayed, in this case it will be displayed in this view;
        //Add more here
    }
}