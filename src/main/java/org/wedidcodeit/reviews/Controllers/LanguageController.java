package org.wedidcodeit.reviews.Controllers;
import org.springframework.web.bind.annotation.*;
import org.wedidcodeit.reviews.Repos.HashtagRepository;
import org.wedidcodeit.reviews.Repos.LanguageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.wedidcodeit.reviews.entities.Hashtag;
import org.wedidcodeit.reviews.entities.Language;
import org.wedidcodeit.reviews.entities.LanguageType;

import java.util.Optional;


@Controller
public class LanguageController {
    private LanguageRepository languageRepo;
    private HashtagRepository hashtagRepo;


    public LanguageController(LanguageRepository languageRepo, HashtagRepository hashtagRepo) {
        this.languageRepo = languageRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping("/languages/{id}")
    public String showLanguagesTemplate(Model model, @PathVariable long id) {
        model.addAttribute("language", languageRepo.findById(id).get());
        return "LanguageDescriptionTemplate";
    }

    @GetMapping("/languages/{id}")
    public String showLanguageTemplate(Model model, @PathVariable long id) {
        Optional<Language> tempLanguage = languageRepo.findById(id);
        if (tempLanguage.isPresent())
        {
            model.addAttribute("language", tempLanguage.get());
        }
        return "LanguageDescriptionTemplate";
    }

    @PostMapping("/languages/{id}")
    public String addReview(@PathVariable long id, @RequestParam String review, @RequestParam String hashtag){
        Language language = languageRepo.findById(id).get();
        language.addReview(review);
        languageRepo.save(language);

        Optional<Hashtag> hashtag1 = hashtagRepo.findByNameIgnoreCase(hashtag);
        if(hashtag1.isPresent()){
            hashtag1.get().addLanguage(language);
            hashtagRepo.save(hashtag1.get());
        }
        else {
            Hashtag hashtag2 = new Hashtag(hashtag);
            hashtag2.addLanguage(language);
            hashtagRepo.save(hashtag2);
        }
        return "redirect:/languages/"+ id;
    }

    @RequestMapping("/languagetypes/languages/{id}/{name}")
    public String showLanguagesByName(Model model, @PathVariable String name) {
        Optional<Language> tempLanguage = languageRepo.findByNameIgnoreCase(name);
        if (tempLanguage.isPresent()) {
            model.addAttribute("inLanguage", tempLanguage.get());
        }
        return "LanguageDescriptionTemplate";
    }


    @GetMapping ("/hashtags")
    public String listHashtags (Model model){
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "hashtags";
    }

    @GetMapping ("/hashtags/{id}")
    public String listHashtags (Model model, @PathVariable long id){
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "hashtag";
    }

}
