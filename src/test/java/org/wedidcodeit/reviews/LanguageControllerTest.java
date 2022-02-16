//package org.wedidcodeit.reviews;
//
//
//
//import org.wedidcodeit.reviews.Repos.LanguageRepository;
//import org.wedidcodeit.reviews.Controllers.LanguageController;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.ui.Model;
//import org.wedidcodeit.reviews.entities.Language;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//
//public class LanguageControllerTest {
//
//    LanguageRepository mockLanguageRepo;
//    LanguageController underTest;
//    Model mockModel;
//    Language tempLanguage;
//
//    @BeforeEach
//    public void setUp(){
//        mockLanguageRepo = mock(LanguageRepository.class);
//        mockModel = mock(Model.class);
//        underTest = new LanguageController(mockLanguageRepo);
//        tempLanguage = new Language(42, "Java",true ,false,false,true);
//    }
//
//    @Test
//    public void shouldRedirectToCorrectTemplate(){
//        //Arrange Action
//        mockLanguageRepo.save(tempLanguage);
//
//        String redirectName = underTest.showLanguageTemplate(mockModel);
//        //Assert
//        assertThat(redirectName).isEqualTo("LanguageTemplate");
//    }
//
//    @Test
//    public void canAddLanguageToRepo(){
//        mockLanguageRepo.save(tempLanguage);
//        verify(mockLanguageRepo).save(tempLanguage);
//    }
//}
