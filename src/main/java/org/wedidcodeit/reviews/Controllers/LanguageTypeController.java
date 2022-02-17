package org.wedidcodeit.reviews.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wedidcodeit.reviews.Repos.LanguageTypeRepository;
import org.wedidcodeit.reviews.entities.LanguageType;
import java.util.Optional;

@Controller
public class LanguageTypeController {
    private LanguageTypeRepository languageTypeRepo;

    public LanguageTypeController(LanguageTypeRepository LanguageTypeRepo) {
        this.languageTypeRepo = languageTypeRepo;
    }


    @RequestMapping("/")
    public String showLanguageTypePage(Model model) {
        model.addAttribute("languageTypes", languageTypeRepo.findAll());
        return "LanguagesTemplate";
    }

    @GetMapping("/languageTypes/{id}")
        public String showLanguageTypeTemplate (Model model, @PathVariable long id){
            Optional<LanguageType> tempLanguageType = languageTypeRepo.findById(id);
            if(tempLanguageType.isPresent()){
                model.addAttribute("inLanguageType", tempLanguageType.get());
        }
        return "LanguageTypesTemplate";
    }
    @RequestMapping("/languageTypes/languages/{language}")
    public String showLanguagesByType(Model model,@PathVariable String languageType){
        Optional<LanguageType> tempLanguageType = languageTypeRepo.findByNameIgnoreCase(languageType);
        if(tempLanguageType.isPresent()){
    model.addAttribute("inLanguageType",tempLanguageType.get());
        }
        return "LanguageTypeTemplate";
    }
}
