package org.wedidcodeit.reviews.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wedidcodeit.reviews.entities.Hashtag;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
}
