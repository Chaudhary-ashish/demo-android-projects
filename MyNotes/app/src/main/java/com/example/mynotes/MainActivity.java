package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView attempts;
    private String usernameans;
    private String userpasswordans;
    private int flag=1;
    private int counter=5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        flag=register.flag;
        if(flag==1)
        {
            flag=0;
            Intent intent = new Intent(MainActivity.this, register.class);
            startActivity(intent);
        }
        Intent intent1=getIntent();
        usernameans=intent1.getStringExtra(register.Et);
        userpasswordans=intent1.getStringExtra(register.Et1);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void setupViews()
    {
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Login=(Button)findViewById(R.id.btnLogin);
        attempts=(TextView)findViewById(R.id.tvInfo);
    }
    private void Validate(String username,String userpassword)
    {
        if((username.equals(usernameans)) && (userpassword.equals(userpasswordans)))
        {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            counter--;
            attempts.setText("No. of attempts remaining : " + String.valueOf(counter));
            if(counter==0)
                Login.setEnabled(false);
        }
    }
}