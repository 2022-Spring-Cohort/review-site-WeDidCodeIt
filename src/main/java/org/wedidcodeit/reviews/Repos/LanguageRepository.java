package org.wedidcodeit.reviews.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wedidcodeit.reviews.entities.Language;

import java.util.Optional;

public interface LanguageRepository extends CrudRepository <Language,Long> {

    Optional<Language> findByNameIgnoreCase(String name);
}
