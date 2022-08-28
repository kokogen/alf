package koko.controllers;

import koko.dto.VacancyDTO;
import koko.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {
    @Autowired
    VacancyService vacancyService;

    @GetMapping("/by/company/{companyId}")
    public Flux<VacancyDTO> findByCompanyId(@PathVariable long companyId) {
        return vacancyService.findByCompanyId(companyId);
    }

    @GetMapping("/by/position/{positionName}")
    public Flux<VacancyDTO> findByPosition(@PathVariable String positionName) {
        return vacancyService.findByPosition(positionName);
    }

    @GetMapping("/{vacancyId}")
    public Mono<VacancyDTO> findById(@PathVariable long vacancyId) {
        return vacancyService.findById(vacancyId);
    }

    @PostMapping
    public Mono<VacancyDTO> save(@RequestBody VacancyDTO vacancyDTO) {
        return vacancyService.save(vacancyDTO);
    }
}
