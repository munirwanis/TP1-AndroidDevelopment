package com.wanis.tp1androiddevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CreateContactActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText phoneEditText;
    EditText emailEditText;
    EditText cityEditText;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        this.setup();
    }

    private void setup() {
        this.nameEditText = (EditText) findViewById(R.id.nameEditText);
        this.phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        this.emailEditText = (EditText) findViewById(R.id.emailEditText);
        this.cityEditText = (EditText) findViewById(R.id.cityEditText);

        this.progressBar = (ProgressBar) findViewById(R.id.createContactProgressBar);
    }

    public void onCreateButtonClick(View view) {
        // CREATE CONTACT
        this.progressBar.setVisibility(View.VISIBLE);
    }

    public void onCleanButtonClick(View view) {
        this.nameEditText.setText(null);
        this.phoneEditText.setText(null);
        this.emailEditText.setText(null);
        this.cityEditText.setText(null);
        Toast.makeText(this, R.string.all_clean_toast, Toast.LENGTH_SHORT).show();
    }

    public void onShowContactsButtonClick(View view) {
        // OPEN ANOTHER ACTIVITY
    }
}
