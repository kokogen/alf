package koko.repo;

import koko.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LocationRepository extends JpaRepository<Location, String> {
}
