package com.wanis.tp1androiddevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);

        this.setup();
    }

    private void setup() {
        try {
            ArrayList contacts = FileManager.readContacts();
            Contacts contactsAdapter = new Contacts(this, contacts);
            ListView listView = (ListView) findViewById(R.id.contactsListView);
            listView.setAdapter(contactsAdapter);
        } catch (Exception e) {
            Toast.makeText(this, R.string.contact_is_empty, Toast.LENGTH_LONG).show();
        }
    }
}
