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
    public LanguageController(LanguageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }


    @RequestMapping("/languagetypes/languages/")
    public String showLanguagesTemplate(Model model, @PathVariable long id) {
        model.addAttribute("inLanguage", languageRepo.findById(id).get());
        return "LanguageDescriptionTemplate";
    }

    @GetMapping("/languages/{id}")
    public String showLanguageTemplate(Model model, @PathVariable long id) {
        Optional<Language> tempLanguage = languageRepo.findById(id);
        if (tempLanguage.isPresent())
        {
            model.addAttribute("language", tempLanguage.get());
        }
<<<<<<< HEAD
        return "LanguageTemplate";
=======
        return "LanguageDescriptionTemplate";
>>>>>>> 73cddcd7692a68dd19e626ce29ec3aa25b7db0d5
    }

    @RequestMapping("/languagetypes/languages/{id}/{name}")
    public String showLanguagesByName(Model model, @PathVariable String name) {
        Optional<Language> tempLanguage = languageRepo.findByNameIgnoreCase(name);
        if (tempLanguage.isPresent()) {
            model.addAttribute("inLanguage", tempLanguage.get());
        }
        return "LanguageDescriptionTemplate";
    }

    @PostMapping("/languagetypes/languages/{id}")
    public String addReview(@PathVariable long id, @RequestParam String review){
        Language language = languageRepo.findById(id).get();
        language.addReview(review);
        languageRepo.save(language);
        return "redirect:/languages/"+ id;
    }

    @GetMapping ("/languagetypes/languages/{id}/addhashtag")
    public String addHashTag (@PathVariable long id, @RequestParam String hashtag){
        Hashtag hashtag1 = new Hashtag(hashtag);
        hashtag1.addLanguage(languageRepo.findById(id).get());
        hashtagRepo.save(hashtag1);
        return "redirect:/languagetypes/languages/"+id+"/addhashtag";
    }




}
