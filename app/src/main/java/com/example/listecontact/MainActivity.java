package com.example.listecontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/* N'ayant aucune possibilité de tester,
les exercices 2 à 3 me sont pas très accessibles.
L'exercice 1 non plus d'ailleurs.
Et n'ayant pas pu tester de la semaine, le contenu
ne sera probablement pas probant.
 */


public class MainActivity extends Activity {

    ListView contacts_view;
    Button buttonEdit;
    ArrayList s = NewContact.listValue;
    static final String STATE_COUNTER = "counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(STATE_COUNTER);
        } else {
            counter = 0;
        }
        setContentView(R.layout.activity_main);

        contacts_view = findViewById(R.id.contacts);

        ArrayList<ArrayList<String>> listContacts = new ArrayList<>();

        ArrayList<String> person0 = new ArrayList<>();
        person0.add("Bill");
        person0.add("Gates");
        person0.add("+5557489652");

        ArrayList<String> person1 = new ArrayList<>();
        person1.add("Pat");
        person1.add("Hibulaire");
        person1.add("+5486215687");

        ArrayList<String> person2 = new ArrayList<>();
        person2.add("Pop");
        person2.add("Eye");
        person2.add("+8415321598");

        listContacts.add(person0);
        listContacts.add(person1);
        listContacts.add(person2);

        if(s.size() != 0){
            listContacts.add(s);
        }

        ArrayAdapter<ArrayList<String>> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listContacts
        );

        contacts_view.setAdapter(adapter);

        buttonEdit = findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewContact.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter ++;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_COUNTER, counter);
        super.onSaveInstanceState(savedInstanceState);
    }

    //@Override
    protected void onStop(Bundle savedInstanceState){
        onSaveInstanceState(savedInstanceState, counter);
        super.onStop();
    }

    //@Override
    protected void onPause(Bundle savedInstanceState){
        onSaveInstanceState(savedInstanceState, counter);
        super.onPause();
    }
}
