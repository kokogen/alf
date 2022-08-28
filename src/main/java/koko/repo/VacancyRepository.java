package koko.repo;

import koko.model.Vacancy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {
    List<Vacancy> findByCompanyId(long companyId);
    List<Vacancy> findByPosition(String position);
}
