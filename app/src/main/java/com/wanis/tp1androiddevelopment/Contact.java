package com.wanis.tp1androiddevelopment;

import android.text.TextUtils;

import org.w3c.dom.Text;

/**
 * Created by munirwanis on 12/11/17.
 */

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String city;

    public Contact(String name, String phone, String email, String city) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean isEmpty() {
        return TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.phone) || TextUtils.isEmpty(this.email) || TextUtils.isEmpty(this.city);
    }

    @Override
    public String toString() {
        return this.name + "|" + this.phone + "|" + this.email + "|" + this.city + "\n";
    }
}
