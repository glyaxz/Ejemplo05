package hl.t1.ejemplo05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String valueClicked = "";
    String operatorClicked = "";
    String operation1 = "";
    String operation2 = "";
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Javier Garcia Ruiz
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        Button[] btnNumberList = {
                findViewById(R.id.btnZero),
                findViewById(R.id.btnOne),
                findViewById(R.id.btnTwo),
                findViewById(R.id.btnThree),
                findViewById(R.id.btnFour),
                findViewById(R.id.btnFive),
                findViewById(R.id.btnSix),
                findViewById(R.id.btnSeven),
                findViewById(R.id.btnEight),
                findViewById(R.id.btnNine),
                findViewById(R.id.btnComa)
        };

        Button[] btnOperatorsList = {
            findViewById(R.id.btnAdd),
            findViewById(R.id.btnSubt),
            findViewById(R.id.btnMult),
            findViewById(R.id.btnDiv),
        };
        Button btnSubmit = findViewById(R.id.btnSubmit);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnCleanOne = findViewById(R.id.btnCleanOne);
        TextView lcd = findViewById(R.id.txtResult);

        //Clickers
            //Numbers
        Arrays.stream(btnNumberList).sequential().forEach(btn -> btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(operatorClicked == ""){
                    operation1 += (String) btn.getText();
                }else{
                    operation2 += (String) btn.getText();
                }
                valueClicked = operation1 + operatorClicked + operation2;
                lcd.setText(valueClicked);
            }
        }));

            //Operators
        Arrays.stream(btnOperatorsList).sequential().forEach(btn -> btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                operatorClicked = (String) btn.getText();
                valueClicked = operation1 + operatorClicked + operation2;
                lcd.setText(valueClicked);

            }
        }));

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                operation1 = "";
                operatorClicked = "";
                operation2 = "";
                valueClicked = operation1 + operatorClicked + operation2;
                lcd.setText(valueClicked);
            }
        });

        btnCleanOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(operatorClicked.isEmpty()){
                        Log.wtf("DEBUG =>","Borrar op1 | " + operation2);
                        operation1 = operation1.substring(0, operation1.length() - 1);
                    }else if(!operatorClicked.isEmpty() && operation2.isEmpty()){
                        Log.wtf("DEBUG =>","Borrar operator");
                        operatorClicked = "";
                    }else{
                        Log.wtf("DEBUG =>","Borrar op2");
                        operation2 = operation2.substring(0, operation2.length() - 1);
                    }
                    valueClicked = operation1 + operatorClicked + operation2;
                    lcd.setText(valueClicked);
                }catch(StringIndexOutOfBoundsException e){
                    //
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DEBUG", "clicked");
                double op1 = Double.parseDouble(operation1);
                double op2 = Double.parseDouble(operation2);
                Log.i("DEBUG", "into if");

                switch (operatorClicked) {
                    case "+":
                        result = op1 + op2;
                        Log.i("DEBUG", "into sw");
                        break;
                    case "-":
                        result = op1 - op2;
                        Log.i("DEBUG", "into sw");
                        break;
                    case "/":
                        if (op1 == 0 || op2 == 0) {
                            result = 0;
                        } else {
                            result = op1 / op2;
                        }
                        Log.i("DEBUG", "into sw");
                        break;
                    case "x":
                        result = op1 * op2;
                        Log.i("DEBUG", "into sw");
                        break;
                    default:
                        result = op1;
                }

                if((int)result == result) {
                    lcd.setText(String.valueOf((int)result));
                    Log.i("DEBUG", "into checker");
                }else{
                    lcd.setText(String.valueOf(result));
                    Log.i("DEBUG", "into checker");
                }

                operatorClicked = "";
                operation1 = "";
                operation2 = "";
            }
        });
    }
}