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

    public Language(long id, String name, boolean isInterpretive, boolean isCompiled,boolean isFrontEnd, boolean isBackEnd) {
    this.id = id;
    this.name = name;
    this.isInterpretive=isInterpretive;
    this.isCompiled=isCompiled;
    this.isFrontEnd=isFrontEnd;
    this.isBackEnd=isBackEnd;
    }


    private Language(){

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



}
