package org.wedidcodeit.reviews.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wedidcodeit.reviews.Repos.LanguageRepository;
import org.wedidcodeit.reviews.Repos.LanguageTypeRepository;
import org.wedidcodeit.reviews.entities.Language;
import org.wedidcodeit.reviews.entities.LanguageType;

import java.util.Optional;

@Controller
public class LanguageTypeController {
    private LanguageTypeRepository languageTypeRepo;
    private LanguageRepository languageRepo;

    public LanguageTypeController(LanguageTypeRepository languageTypeRepo, LanguageRepository languageRepo) {
        this.languageTypeRepo = languageTypeRepo;
        this.languageRepo = languageRepo;
    }


    @RequestMapping("/")
    public String showLanguageTypesPage(Model model) {
        model.addAttribute("languageTypes", languageTypeRepo.findAll());
        return "LanguageTypesTemplate";
    }

    @RequestMapping("/languagetypes/{id}")
    public String showLanguageTypeTemplateById(Model model, @PathVariable long id) {
        Optional<LanguageType> tempLanguageType = languageTypeRepo.findById(id);
        if (tempLanguageType.isPresent()) {
            model.addAttribute("inLanguageType", tempLanguageType.get());
        }

        Optional<Language> tempLanguage = languageRepo.findById(id);
        if (tempLanguage.isPresent()) {
            model.addAttribute("inLanguage", tempLanguage.get());
        }
        return "LanguageTypeTemplate";
    }

    @RequestMapping("/LanguageTypesTemplate")
    public String LanguageTypesTemplates() {
        return "LanguageTypesTemplate";
    }

}
