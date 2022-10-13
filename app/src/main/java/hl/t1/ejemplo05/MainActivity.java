package hl.t1.ejemplo05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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
            findViewById(R.id.btnNine)
    };

    Button[] btnFunctionList = {
            findViewById(R.id.btnAdd),
            findViewById(R.id.btnSubt),
            findViewById(R.id.btnMult),
            findViewById(R.id.btnDiv),
            findViewById(R.id.btnSubmit)
    };

    Button[] btnCleanList = {
            findViewById(R.id.btnCleanOne),
            findViewById(R.id.btnClear)
    };

    Button btnComa = findViewById(R.id.btnComa);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Javier Garcia Ruiz
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Functions
        /*
        for(int i = 0; i <= btnNumberList.length; i++){
            btnNumberList[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
        */
    }
}