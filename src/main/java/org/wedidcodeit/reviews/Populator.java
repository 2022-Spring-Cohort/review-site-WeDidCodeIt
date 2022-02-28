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
        LanguageType interpretive = new LanguageType("Interpretive", "Temp", "Generally interpreted without compiling a program into machine instructions. It is one where the instructions are not directly executed by the target machine, but instead read and executed by some other program.","/pics/interpcode.jpg");
        LanguageType compiled = new LanguageType("Compiled", "Temp", "Compiled languages are converted directly into machine code that the processor can execute. As a result, they tend to be faster and more efficient to execute than interpreted languages.","/pics/compiledcode.jpg");
        languageTypeRepo.save(interpretive);
        languageTypeRepo.save(compiled);
        Language java = new Language("Java",false,true ,79000,"James Gosling","Temp", compiled,"/pics/java.png");
        languageRepo.save(java);

        Language kotlin = new Language( "Kotlin", true, true,136000, "JetBrains", "Temp", compiled,"/pics/Kotlin.png");
        languageRepo.save(kotlin);

        Language python = new Language( "Python", true, true, 72500, "Guido van Rossum", "Temp", interpretive,"/pics/python.png");
        languageRepo.save(python);

        Language swift = new Language( "Swift", false, true, 96000, "Ted Kremenek", "Temp", compiled,"/pics/Swift.png");
        languageRepo.save(swift);

        Language cSharp = new Language( "C#", false, true, 68000, "Microsoft", "Temp", compiled,"/pics/CSharp.png");
        languageRepo.save(cSharp);

        Language go = (new Language( "Go", true, true, 92000, "Rob Pike", "Temp", compiled,"/pics/GO.png"));
        languageRepo.save(go);

        Language php = new Language( "PHP", false, true, 81500, "Rasmus Ierdorf", "Temp", compiled,"/pics/php.png");
        languageRepo.save(php);

        Language matLab = new Language( "MatLab", true, true, 101000, "Cleve Moler", "Temp", interpretive,"/pics/mat.jpg");
        languageRepo.save(matLab);

        Language r = new Language( "R",false, true, 91000, "Robert Gentleman", "Temp", interpretive,"/pics/R.jpg");
        languageRepo.save(r);

        Language htmlCSS = new Language( "HTML/CSS", true, false, 68000, "World Wide Web Consortium", "Temp", interpretive,"/pics/html.jpg");
        languageRepo.save(htmlCSS);


        Hashtag hashtag1 = new Hashtag("EasyToUse");
        hashtag1.addLanguage(java);
        hashtagRepo.save(hashtag1);


        Hashtag compiledHashtag = new Hashtag("Compiled");
        compiledHashtag.addLanguage(java);
        compiledHashtag.addLanguage(kotlin);
        compiledHashtag.addLanguage(swift);
        compiledHashtag.addLanguage(cSharp);
        compiledHashtag.addLanguage(go);
        compiledHashtag.addLanguage(php);
        hashtagRepo.save(compiledHashtag);

        Hashtag interpretiveHashtag = new Hashtag("Interpretive");
        interpretiveHashtag.addLanguage(python);
        interpretiveHashtag.addLanguage(matLab);
        interpretiveHashtag.addLanguage(r);
        interpretiveHashtag.addLanguage(htmlCSS);
        hashtagRepo.save(interpretiveHashtag );








    }

}
