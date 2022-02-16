package org.wedidcodeit.reviews.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.wedidcodeit.reviews.Repos.LanguageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LanguageController {
    private LanguageRepository languageRepo;

    public LanguageController(LanguageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }

    @RequestMapping("/")
    public String showLanguagesTemplate(Model model) {
        model.addAttribute("languages", languageRepo.findAll());
        return "LanguagesTemplate";
    }

    @RequestMapping("/language/{id}")
    public String showLanguageTemplate(Model model, @PathVariable long id) {
        model.addAttribute("inLanguage", languageRepo.findById(id).get());
        return "LanguageTemplate";
    }
}
