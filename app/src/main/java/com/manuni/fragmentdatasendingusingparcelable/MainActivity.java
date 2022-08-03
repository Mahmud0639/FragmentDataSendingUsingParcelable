package com.manuni.fragmentdatasendingusingparcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nameET, genderET, ageET;
    private AppCompatButton sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameET.getText().toString();
                String gender = genderET.getText().toString();
                int age = Integer.parseInt(ageET.getText().toString());

                DataReceiverFragment dataReceiverFragment = new DataReceiverFragment();
                Bundle bundle = new Bundle();
                Person person = new Person(name,gender,age);
                bundle.putParcelable("key",person);
                dataReceiverFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fragContainer,dataReceiverFragment).commit();
            }
        });


    }
    private void initViews(){
        nameET = findViewById(R.id.nameET);
        genderET = findViewById(R.id.genderET);
        ageET = findViewById(R.id.ageET);
        sendBtn = findViewById(R.id.sendBtn);
    }
}