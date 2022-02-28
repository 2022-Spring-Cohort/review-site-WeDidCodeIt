package org.wedidcodeit.reviews.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wedidcodeit.reviews.entities.Language;
import org.wedidcodeit.reviews.entities.LanguageType;

import java.util.Optional;

public interface LanguageTypeRepository extends CrudRepository<LanguageType,Long> {
    Optional<LanguageType> findByNameIgnoreCase(String name);
}
