package koko.repo;

import koko.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findByCompanyId(long companyId);
    List<Vacancy> findByPosition(String position);
}
