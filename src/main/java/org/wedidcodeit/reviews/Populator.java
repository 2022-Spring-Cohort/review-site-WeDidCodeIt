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

        languageRepo.save(new Language(24, "Python","name of the inventor",true ,false,false,true));

    }

}
