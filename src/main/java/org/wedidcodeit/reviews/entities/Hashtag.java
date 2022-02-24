package org.wedidcodeit.reviews.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;


    @Entity
    public class Hashtag {
        @Id
        @GeneratedValue
        private long id;
        private String name;

        @ManyToMany
        Collection<Language> languages;


        public Hashtag(String name) {
            this.name = name;
            this.languages= new ArrayList<>();
        }

        public Hashtag() {

        }

        public void addLanguage (Language language){
            languages.add(language);
        }


        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Collection<Language> getLanguages() {
            return languages;
        }
    }

