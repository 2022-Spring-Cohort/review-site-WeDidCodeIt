package org.wedidcodeit.reviews;

import org.wedidcodeit.reviews.Repos.HashtagRepository;
import org.wedidcodeit.reviews.Repos.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wedidcodeit.reviews.Repos.LanguageTypeRepository;
import org.wedidcodeit.reviews.entities.Hashtag;
import org.wedidcodeit.reviews.entities.Language;
import org.wedidcodeit.reviews.entities.LanguageType;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    LanguageRepository languageRepo;

    @Autowired
    LanguageTypeRepository languageTypeRepo;

    @Autowired
    HashtagRepository hashtagRepo;


    @Override
    public void run(String...args) throws Exception{
        LanguageType interpretive = new LanguageType("interpretive", "Temp", "Temp");
        LanguageType compiled = new LanguageType("compiled", "Temp", "Temp");
        languageTypeRepo.save(interpretive);
        languageTypeRepo.save(compiled);
        Language java = new Language("Java",false,true ,79000,"James Gosling","Temp", compiled);
        languageRepo.save(java);

//        languageRepo.save(new Language(24, "Python","name of the inventor",true ,false,false,true));
        languageRepo.save(new Language( "Kotlin", true, true,136000, "JetBrains", "Temp", compiled));
        languageRepo.save(new Language( "Python", true, true, 72500, "Guido van Rossum", "Temp", interpretive));
        languageRepo.save(new Language( "Swift", false, true, 96000, "Ted Kremenek", "Temp", compiled));
        languageRepo.save(new Language( "C#", false, true, 68000, "Microsoft", "Temp", compiled));
        languageRepo.save(new Language( "Go", true, true, 92000, "Rob Pike", "Temp", compiled));
        languageRepo.save(new Language( "PHP", false, true, 81500, "Rasmus Ierdorf", "Temp", compiled));
        languageRepo.save(new Language( "MatLab", true, true, 101000, "Cleve Moler", "Temp", interpretive));
        languageRepo.save(new Language( "R",false, true, 91000, "Robert Gentleman", "Temp", interpretive));
        languageRepo.save(new Language( "HTML/CSS", true, false, 68000, "World Wide Web Consortium", "Temp", interpretive));


        Hashtag hashtag1 = new Hashtag("EasyToUse");
        hashtag1.addLanguage(java);

        hashtagRepo.save(hashtag1);


    }

}
