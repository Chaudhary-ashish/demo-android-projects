package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class register extends AppCompatActivity {
    public static final String Et = "com.example.mynotes.Et";
    public static final String Et1 = "com.example.mynotes.Et1";
    public static  int flag=1;



    private TextView Name;
    private TextView Pass;
    private Button Register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name=(TextView)findViewById(R.id.EtNam);
        Pass=(TextView)findViewById(R.id.etPass);
        Register=(Button)findViewById(R.id.btnreg);
        Register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String t1,t2;
                t1=Name.getText().toString();
                t2=Pass.getText().toString();
                 Intent intent = new Intent(register.this,MainActivity.class);
                 flag=0;
                 intent.putExtra(Et,t1);
                 intent.putExtra(Et1,t2);
                 startActivity(intent);

            }
        });
    }
}