package org.wedidcodeit.reviews.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity

public class Language {

    @Id
    @GeneratedValue
    private long id;
    private String name;


    @ManyToMany (mappedBy = "languages")
    Collection <Hashtag> hashtags;


    private String logoUrl;
    private boolean isFrontEnd;
    private boolean isBackEnd;
    private double averageSalary;
    private String inventor;
    private String uses;


    @ManyToOne
    private LanguageType languageType;



    @ElementCollection
    private Collection<String> reviews;

    public Language(String name, boolean isFrontEnd, boolean isBackEnd, double averageSalary, String inventor, String uses, LanguageType languageType, String logoUrl) {
        this.name = name;
        this.isFrontEnd = isFrontEnd;
        this.isBackEnd = isBackEnd;
        this.averageSalary = averageSalary;
        this.inventor = inventor;
        this.uses = uses;
        this.languageType = languageType;
        this.logoUrl = logoUrl;
        this.reviews= new ArrayList<>();
    }


    private Language(){

    }


    public Collection<Hashtag> getHashtags() {
        return hashtags;
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



    public boolean isFrontEnd() {
        return isFrontEnd;
    }

    public boolean isBackEnd() {
        return isBackEnd;
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


    public String getLogoUrl() {
        return logoUrl;
    }
}
