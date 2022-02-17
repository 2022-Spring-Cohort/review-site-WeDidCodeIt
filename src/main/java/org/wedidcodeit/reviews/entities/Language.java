package org.wedidcodeit.reviews.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private boolean isInterpretive;
    private boolean isCompiled;
    private boolean isFrontEnd;
    private boolean isBackEnd;
    private double averageSalary;
    private String inventor;
    private String uses;
    private int salary;

    public Language(long id, String name, String inventor, boolean isInterpretive, boolean isCompiled,boolean isFrontEnd, boolean isBackEnd) {
    this.id = id;
    this.name = name;
    this.isInterpretive=isInterpretive;
    this.isCompiled=isCompiled;
    this.isFrontEnd=isFrontEnd;
    this.inventor=inventor;
    this.isBackEnd=isBackEnd;
    this.salary=salary;
    }


    private Language(){

    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public String getInventor() {
        return inventor;
    }

    public String getUses() {
        return uses;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public boolean isInterpretive() {
        return isInterpretive;
    }

    public boolean isCompiled() {
        return isCompiled;
    }

    public boolean isFrontEnd() {
        return isFrontEnd;
    }

    public boolean isBackEnd() {
        return isBackEnd;
    }

    public int isSalary() { return salary; }



}
