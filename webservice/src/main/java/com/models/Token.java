package com.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;

import java.util.Calendar;
import java.util.Date;

@Entity(name = "token")
public class Token {

    @Column
    private int iduser;
    @Id
    @Column
    private String token;
    @Column
    private Date datecreation;
    @Column
    private double duree;
    @Column
    private Date datexpiration;


    public Token(int iduser) {
        this.iduser = iduser;
        this.datecreation = Token.getDateNow();
        this.token = Token.createToken(""+iduser,this.datecreation.toString());
        this.duree = 300;
        Calendar cal=Calendar.getInstance();
        cal.setTime(datecreation);
        Double d=new Double(duree);
        cal.add(Calendar.SECOND,d.intValue());
        this.datexpiration= cal.getTime();
    }

    public Token(){}

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public static Date getDateNow(){
        Calendar cal=Calendar.getInstance();
        return cal.getTime();
    }

    public Date getDatexpiration() {
        return datexpiration;
    }

    public void setDatexpiration(Date datexpiration) {
        this.datexpiration = datexpiration;
    }

    public static String createToken(String input, String date)
    {
        try {
            input+=date;
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
