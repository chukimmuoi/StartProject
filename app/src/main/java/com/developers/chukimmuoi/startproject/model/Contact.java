package com.developers.chukimmuoi.startproject.model;

import java.util.ArrayList;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 4/2/17.
 */

public class Contact {
    private String name;

    private boolean isOnline;

    public Contact(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    private static int lastContactId = 0;

    public static ArrayList<? super Object> createContactsList(int numContacts, int offset) {
        ArrayList<? super Object> contacts = new ArrayList<>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId + " offset: " + offset, i <= numContacts / 2));
        }

        return contacts;
    }
}
