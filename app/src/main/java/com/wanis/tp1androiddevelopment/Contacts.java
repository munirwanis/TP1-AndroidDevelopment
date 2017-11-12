package com.wanis.tp1androiddevelopment;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by munirwanis on 12/11/17.
 */

public class Contacts {
    private ArrayList<Contact> contacts;

    public Contacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public Contacts() {
        this.contacts = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getContacts() throws IOException {
        try {
            String stringContacts = FileManager.Read();

            String[] contactsLine = stringContacts.split("\n");

            for (String contactLine :
                    contactsLine) {
                String[] contactSeparated = contactLine.split("|");
                Contact contact = new Contact(contactSeparated[0], contactSeparated[1], contactSeparated[2], contactSeparated[3]);

                this.contacts.add(contact);
            }

        } catch (Exception e) {
            throw e;
        }

        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        String message = "";

        for (Contact contact :
                contacts) {
            message = message.concat(contact.toString());
        }
        return message;
    }
}
