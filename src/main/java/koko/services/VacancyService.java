package koko.services;

import koko.dto.VacancyDTO;
import koko.repo.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VacancyService {
    @Autowired
    VacancyRepository repository;

    public Flux<VacancyDTO> findByCompanyId(long companyId) {
        return Flux.fromStream(repository.findByCompanyId(companyId).stream().map(Util::toVacancyDTO));
    }

    public Flux<VacancyDTO> findByPosition(String positionName) {
        return Flux.fromStream(repository.findByPosition(positionName).stream().map(Util::toVacancyDTO));
    }

    public Mono<VacancyDTO> findById(long vacancyId) {
        return repository.findById(vacancyId)
                .map(vacancy -> Mono.just(Util.toVacancyDTO(vacancy)))
                .orElseGet(Mono::empty);
    }

    public Mono<VacancyDTO> save(VacancyDTO vacancyDTO){
        repository.save(Util.toVacancy(vacancyDTO));
        return Mono.just(vacancyDTO);
    }
}
