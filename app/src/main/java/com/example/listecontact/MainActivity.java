package com.example.listecontact;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout editContactLayout = new LinearLayout(this);
        //editContactLayout.setOrientation(LinearLayout.VERTICAL);

        TextView nameEditTextView = new TextView(this);
        nameEditTextView.setText("Nom?");
        TextView firstNameEditTextView = new TextView(this);
        firstNameEditTextView.setText("Prénom?");
        TextView telEditView = new TextView(this);
        telEditView.setText("Tel?");
    }
}
