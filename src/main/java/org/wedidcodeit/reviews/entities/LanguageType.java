package org.wedidcodeit.reviews.entities;
import org.hibernate.tuple.entity.EntityMetamodel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class LanguageType {

    @Id
    @GeneratedValue
    private long id;
    private String languageName;
    private String uses;
    private String description;

    public LanguageType(long id, String languageName, String uses, String description) {
        this.id = id;
        this.languageName = languageName;
        this.uses = uses;
        this.description = description;
    }

    @ElementCollection
    private Collection<String> reviews; // Consider changing this//

    @OneToMany(mappedBy = "languageType")
    private Collection<Language> languages;


    private LanguageType() {
    }

    public long getId() {
        return id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getUses() {
        return uses;
    }

    public String getDescription() {
        return description;
    }

    public Collection<String> getReviews() {
        return reviews;
    }
    public void addReview(String review){
        reviews.add(review);
    }
}
