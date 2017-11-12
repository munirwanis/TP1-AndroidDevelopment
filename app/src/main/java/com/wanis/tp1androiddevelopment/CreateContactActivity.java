package com.wanis.tp1androiddevelopment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import static com.wanis.tp1androiddevelopment.FileManager.readContacts;

public class CreateContactActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

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

    private void checkForStoragePermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                Toast.makeText(this, R.string.ask_write_storage_permission, Toast.LENGTH_LONG);

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    this.checkForStoragePermission();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void onCreateButtonClick(View view) {
        this.progressBar.setVisibility(View.VISIBLE);

        this.checkForStoragePermission();

        String name = this.nameEditText.getText().toString();
        String phone = this.phoneEditText.getText().toString();
        String email = this.emailEditText.getText().toString();
        String city = this.cityEditText.getText().toString();

        Contact contact = new Contact(name, phone, email, city);

        if (contact.isEmpty()) {
            Toast.makeText(this, R.string.contact_is_empty, Toast.LENGTH_LONG).show();
        } else {
            try {
                FileManager.Store(contact.toString());
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        this.progressBar.setVisibility(View.INVISIBLE);
    }

    public void onCleanButtonClick(View view) {
        this.nameEditText.setText(null);
        this.phoneEditText.setText(null);
        this.emailEditText.setText(null);
        this.cityEditText.setText(null);
        Toast.makeText(this, R.string.all_clean_toast, Toast.LENGTH_SHORT).show();
    }

    public void onShowContactsButtonClick(View view) {
        try {
            ArrayList contacts = FileManager.readContacts();
            if (contacts.isEmpty()) {
                Toast.makeText(this, R.string.contact_is_empty, Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(this, ListContactsActivity.class);
                startActivity(intent);
            }

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
