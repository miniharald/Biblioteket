package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User extends Base {


    private String name;
    private String address;
    private String mail;
    private String tel;
    private String activeLoans;
    private String uniqueId;

    public User(String name, String address, String mail, String tel) {
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.tel = tel;
        this.activeLoans = "";
        this.uniqueId = idGenerator();
    }

    public User(List<String> userInfoFromDisk) {
        //String[] stringsInfo = userInfoFromDisk.split("\\r?\\n");
        for (String s : userInfoFromDisk) {
            String trim = s.substring(s.indexOf(":") + 1).trim();
            if (s.contains("name:")) {
                this.name = trim;
            } else if (s.contains("address:")) {
                this.address = trim;
            } else if (s.contains("mail:")) {
                this.mail = trim;
            } else if (s.contains("tel:")) {
                this.tel = trim;
            } else if (s.contains("activeLoans:")) {
                this.activeLoans = trim;
            } else if (s.contains("uniqueId:")) {
                this.uniqueId = trim;
            }
        }
    }
    /*public User(List<String> readFromFile) {
        int i = 0;
        String[] stringsInfo = new String [6];
        for(String content:readFromFile){
            String trim = content.substring(content.indexOf(":") + 1).trim();
            stringsInfo[i] = trim;
            i++;
        }
        this.name = stringsInfo[0];
        this.address = stringsInfo[1];
        this.mail = stringsInfo[2];
        this.tel = stringsInfo[3];
        this.activeLoans = stringsInfo[4];
        this.uniqueId = stringsInfo[5];
    }*/

    private String idGenerator() {
        String result = "";
        Random randomizer = new Random();
        for (int i = 0; i < 5; i++) {
            char a = (char) (randomizer.nextInt(26) + 'a');
            int b = (int) (randomizer.nextInt(10));
            result = result.concat(String.valueOf(a));
            result = result.concat(String.valueOf(b));
        }
        return result;
    }

    public String getId() {
        return this.uniqueId;
    }


    public String activeLoansInfo() {
        String result = "";

        /* splitta str??ngen vid mellanslag,
        s??k i disk efter isbn
        */
        if(!this.activeLoans.equals("")){
        String isbnString = this.activeLoans.substring(this.activeLoans.indexOf(":") + 1);

        String[] isbnStringList = isbnString.split(" ");
        for (String s : isbnStringList) {
            //skicka str??ngen tilll readFromDisk, hitta filen som har denna str??ng i sig
            result = result.concat(searchInFile(s, "database/books"));
        }
        }

        return result;
    }

    public String getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(String loaned) {
        this.activeLoans = loaned;
    }


    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return "name: " + this.name + "\naddress: " + this.address + "\nmail: " + this.mail +
                "\ntel: " + this.tel + "\nactiveLoans: " + this.activeLoans + "\nuniqueId: "+this.uniqueId;

    }
}


