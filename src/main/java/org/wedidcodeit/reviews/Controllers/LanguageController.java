package org.wedidcodeit.reviews.Controllers;
import org.springframework.web.bind.annotation.*;
import org.wedidcodeit.reviews.Repos.LanguageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.wedidcodeit.reviews.entities.Language;
import org.wedidcodeit.reviews.entities.LanguageType;

import java.util.Optional;


@Controller
public class LanguageController {
    private LanguageRepository languageRepo;
    public LanguageController(LanguageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }


    @RequestMapping("/languagetypes/languages/")
    public String showLanguagesTemplate(Model model, @PathVariable long id) {
        model.addAttribute("inLanguage", languageRepo.findById(id).get());
        return "LanguagesTemplate";
    }

    @GetMapping("/languagetypes/languages/{id}")
    public String showLanguageTemplate(Model model, @PathVariable long id) {
        Optional<Language> tempLanguage = languageRepo.findById(id);
        if (tempLanguage.isPresent())
        {
            model.addAttribute("inLanguage", tempLanguage.get());
        }
        return "LanguagesTemplate";
    }

    @RequestMapping("/languagetypes/language/{name}")
    public String showLanguagesByName(Model model, @PathVariable String name) {
        Optional<Language> tempLanguage = languageRepo.findByNameIgnoreCase(name);
        if (tempLanguage.isPresent()) {
            model.addAttribute("inLanguage", tempLanguage.get());
        }
        return "LanguageTemplate";
    }

    @PostMapping("/languagetypes/languages/{id}")
    public String addReview(@PathVariable long id, @RequestParam String review){
        Language language = languageRepo.findById(id).get();
        language.addReview(review);
        languageRepo.save(language);
        return "redirect:/languages/"+ id;
    }



}
