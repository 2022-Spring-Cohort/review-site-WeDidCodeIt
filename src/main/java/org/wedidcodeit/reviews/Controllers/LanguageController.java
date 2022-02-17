package org.wedidcodeit.reviews.Controllers;
import org.springframework.web.bind.annotation.*;
import org.wedidcodeit.reviews.Repos.LanguageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.wedidcodeit.reviews.entities.Language;

import java.util.Optional;


@Controller
public class LanguageController {
    private LanguageRepository languageRepo;
    public LanguageController(LanguageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }


    @RequestMapping("/language/{id}")
    public String showLanguagesTemplate(Model model, @PathVariable long id) {
        model.addAttribute("inLanguage", languageRepo.findById(id).get());
        return "LanguageTemplate";
    }

    @GetMapping("/language/{id}")
    public String showLanguageTemplate(Model model, @PathVariable long id) {
        Optional<Language> tempLanguage = languageRepo.findById(id);
        if (tempLanguage.isPresent())
        {
            model.addAttribute("inLanguage", tempLanguage.get());
        }
        return "LanguageTemplate";
    }
    @PostMapping("/languages/{id}")
    public String addReview(@PathVariable long id, @RequestParam String review){
        Language language = languageRepo.findById(id).get();
        language.addReview(review);
        languageRepo.save(language);
        return "redirect:/languages/"+ id;
    }

    @RequestMapping("/books/title/{title}")
    public String showLanguagesByType(Model model, @PathVariable String title) {
        Optional<Language> tempLanguage = languageRepo.findByNameIgnoreCase(title);
        if (tempLanguage.isPresent())
        {
            model.addAttribute("inLanguage", tempLanguage.get());
        }
        return "LanguageTemplate";
    }




}
