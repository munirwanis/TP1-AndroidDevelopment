package com.wanis.tp1androiddevelopment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by munirwanis on 12/11/17.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private ArrayList<Contact> contacts;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        super(context, 0, contacts);
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact contact = this.contacts.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.contact_adapter, null);

        TextView name = convertView.findViewById(R.id.nameContactTextView);
        name.setText(contact.getName());

        TextView phone = convertView.findViewById(R.id.phoneContactTextView);
        phone.setText(contact.getPhone());

        TextView email = convertView.findViewById(R.id.emailContactTextView);
        email.setText(contact.getEmail());

        TextView city = convertView.findViewById(R.id.cityContactTextView);
        city.setText(contact.getCity());

        return convertView;
    }
}
