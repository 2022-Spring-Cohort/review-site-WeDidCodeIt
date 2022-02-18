package org.wedidcodeit.reviews;

import org.wedidcodeit.reviews.Repos.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wedidcodeit.reviews.Repos.LanguageTypeRepository;
import org.wedidcodeit.reviews.entities.Language;
import org.wedidcodeit.reviews.entities.LanguageType;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    LanguageRepository languageRepo;

    @Autowired
    LanguageTypeRepository languageTypeRepo;


    @Override
    public void run(String...args) throws Exception{
        LanguageType interpretive = new LanguageType("interpretive", "Temp", "Temp");
        LanguageType compiled = new LanguageType("compiled", "Temp", "Temp");
        languageTypeRepo.save(interpretive);
        languageTypeRepo.save(compiled);
        Language language = new Language("Java","James Gosling",false ,true,false,true, "$79,000");
        languageRepo.save(language);

//        languageRepo.save(new Language(24, "Python","name of the inventor",true ,false,false,true));
        languageRepo.save(new Language( "Kotlin", false, true,true, true, 136000, "JetBrains", "Temp", compiled);
        languageRepo.save(new Language( "Python", "Guido van Rossum", true, false, true, true, "$72,500"));
        languageRepo.save(new Language( "Swift", "Ted Kremenek", false, true, true, true, "$96,000"));
        languageRepo.save(new Language( "C#", "Microsoft", false, true, true, true, "$68,000"));
        languageRepo.save(new Language( "Go", "Robert Pike", false, true, true, true, "$92,000"));
        languageRepo.save(new Language( "PHP", "Ramsmus Lerdorf", false, true, true, true, "$81,500"));
        languageRepo.save(new Language( "MatLab", "Cleve Moler", true, false, true, true, "$101,000"));
        languageRepo.save(new Language( "R","Robert Gentleman", true, false, false, true, "$91,000"));
        languageRepo.save(new Language( "HTML/CSS", "World Wide Web Consortium", true, false, true, false, "$68,707"));

    }

}
