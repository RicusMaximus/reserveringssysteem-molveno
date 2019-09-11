package com.hotel.reservationsystem.models;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.ArrayList;

public class Reservation {
    private int reserveringsNummer;
    //private ArrayList<Kamer> kamers;
    private int aantalVolwassenen;
    private int aantalKinderen;
    private boolean ontbijtInbegrepen;
    private boolean heeftBalkon;
    private boolean heeftUitzichtOpMeer;
    private String bijzonderheden;
    private Date startDatum;
    private Date eindDatum;
    private Date reserveringsDatum;

    public Reservation(int aantalVolwassenen, int aantalKinderen, boolean ontbijtInbegrepen,
                       boolean heeftBalkon, boolean heeftUitzichtOpMeer, String bijzonderheden, Date startDatum, Date eindDatum) {

        this.aantalVolwassenen = aantalVolwassenen;
        this.aantalKinderen = aantalKinderen;
        this.ontbijtInbegrepen = ontbijtInbegrepen;
        this.heeftBalkon = heeftBalkon;
        this.heeftUitzichtOpMeer = heeftUitzichtOpMeer;
        this.bijzonderheden = bijzonderheden;
        this.startDatum = startDatum;
        this.eindDatum = eindDatum;

        this.reserveringsDatum = new Date();
    }

    public void printProperties() {
        System.out.println(aantalVolwassenen + "\n" + aantalKinderen + "\n" + ontbijtInbegrepen + "\n"
                +heeftBalkon + "\n" +heeftUitzichtOpMeer + "\n" + startDatum + "\n" + eindDatum + "\n" + reserveringsDatum);
    }
}