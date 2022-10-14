package hl.t1.ejemplo05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
                Toast.makeText(MainActivity.this, btn.getText(), Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MainActivity.this, btn.getText(), Toast.LENGTH_SHORT).show();
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
                    valueClicked = valueClicked.substring(0, valueClicked.length() - 1);
                    Toast.makeText(MainActivity.this, valueClicked, Toast.LENGTH_SHORT).show();
                    Log.wtf("DEBUG ======>", "'" + valueClicked + "'");
                    lcd.setText(valueClicked);
                }catch(StringIndexOutOfBoundsException e){
                    //
                }
            }
        });

    }
}