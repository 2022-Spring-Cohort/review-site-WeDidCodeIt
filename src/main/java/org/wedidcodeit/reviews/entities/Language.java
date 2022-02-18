package org.wedidcodeit.reviews.entities;


import javax.persistence.*;
import java.util.Collection;

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
    private String salary;

    @ManyToOne
    private LanguageType languageType;

    @ElementCollection
    private Collection<String> reviews;

    public Language(String name, boolean isInterpretive, boolean isCompiled, boolean isFrontEnd, boolean isBackEnd, double averageSalary, String inventor, String uses, LanguageType languageType) {
        this.name = name;
        this.isInterpretive = isInterpretive;
        this.isCompiled = isCompiled;
        this.isFrontEnd = isFrontEnd;
        this.isBackEnd = isBackEnd;
        this.averageSalary = averageSalary;
        this.inventor = inventor;
        this.uses = uses;
        this.languageType = languageType;

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

    public String getSalary() {
        return salary;
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public Collection<String> getReviews() {
        return reviews;
    }
    public void addReview(String review){
        reviews.add(review);
    }

    public String isSalary() { return salary; }




}
