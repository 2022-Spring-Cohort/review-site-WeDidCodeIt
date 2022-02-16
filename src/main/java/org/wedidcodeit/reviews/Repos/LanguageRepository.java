package org.wedidcodeit.reviews.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wedidcodeit.reviews.entities.Language;

public interface LanguageRepository extends CrudRepository <Language,Long> {
}
