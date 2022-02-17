package org.wedidcodeit.reviews;

import org.wedidcodeit.reviews.Repos.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wedidcodeit.reviews.entities.Language;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    LanguageRepository languageRepo;

    @Override
    public void run(String...args) throws Exception{
        Language language = new Language(42, "Java","name of the inventor",true ,false,false,true);
        languageRepo.save(language);

//        languageRepo.save(new Language(24, "Python","name of the inventor",true ,false,false,true));
        languageRepo.save(new Language(34, "Kotlin", "JetBrains", false, true,true, true));
        languageRepo.save(new Language(33, "Python", "Guido van Rossum", true, false, true, true));
        languageRepo.save(new Language(22, "Swift", "Ted Kremenek", false, true, true, true));
        languageRepo.save(new Language(64, "C#", "Microsoft", false, true, true, true));
        languageRepo.save(new Language(76, "Go", "Robert Pike", false, true, true, true));
        languageRepo.save(new Language(35, "PHP", "Ramsmus Lerdorf", false, true, true, true));
        languageRepo.save(new Language(94, "MatLab", "Cleve Moler", true, false, true, true));
        languageRepo.save(new Language(83, "R","Robert Gentleman", true, false, false, true));
        languageRepo.save(new Language(47, "HTML/CSS", "World Wide Web Consortium", true, false, true, false));

    }

}
