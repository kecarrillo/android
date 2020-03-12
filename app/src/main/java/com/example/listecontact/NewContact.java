package com.example.listecontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NewContact extends Activity {

    public Button buttonView;
    public Button buttonValid;
    private EditText firstName;
    private EditText lastName;
    private EditText phoneNumber;
    public static ArrayList<String> listValue = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        buttonView = findViewById(R.id.buttonView);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewContact.this, MainActivity.class);
                startActivity(intent);
            }
        });

        firstName = (EditText) findViewById(R.id.editFirstName);
        lastName = (EditText) findViewById(R.id.editName);
        phoneNumber = (EditText) findViewById(R.id.editPhone);
        buttonValid = findViewById(R.id.buttonEdit);
        buttonValid.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                String val1=firstName.getText().toString().trim();
                String val2=lastName.getText().toString().trim();
                String val3=phoneNumber.getText().toString().trim();
                if(val1.length() != 0 && val2.length() != 0 && val3.length() != 0){
                    listValue.add(val1);
                    listValue.add(val2);
                    listValue.add(val3);
                    firstName.setText("");
                    lastName.setText("");
                    phoneNumber.setText("");
                }
            }

        });
    }
}
