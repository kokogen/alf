package koko.services;

import koko.dto.CompanyDTO;
import koko.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository repository;

    public Mono<CompanyDTO> findById(long id) {
        return repository.findById(id)
                .map(c -> Mono.just(Util.toCompanyDTO(c)))
                .orElse(Mono.empty());
    }

    public Flux<CompanyDTO> findByName(String companyName) {
        return Flux.fromStream(repository.findByName(companyName).stream().map(Util::toCompanyDTO));
    }

    public Mono<CompanyDTO> save(CompanyDTO companyDTO) {
        repository.save(Util.toCompany(companyDTO));
        return Mono.just(companyDTO);
    }
}
