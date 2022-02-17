package org.wedidcodeit.reviews.entities;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @ElementCollection
    private Collection<String> reviews;

    public Language(long id, String name, String inventor, boolean isInterpretive, boolean isCompiled,boolean isFrontEnd, boolean isBackEnd) {
    this.id = id;
    this.name = name;
    this.isInterpretive=isInterpretive;
    this.isCompiled=isCompiled;
    this.isFrontEnd=isFrontEnd;
    this.inventor=inventor;
    this.isBackEnd=isBackEnd;
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

    public Collection<String> getReviews() {
        return reviews;
    }
    public void addReview(String review){
        reviews.add(review);
    }



}
