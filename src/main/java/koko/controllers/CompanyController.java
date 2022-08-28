package koko.controllers;

import koko.dto.CompanyDTO;
import koko.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/{companyId}")
    public Mono<CompanyDTO> findById(@PathVariable long companyId) {
        return companyService.findById(companyId);
    }

    @GetMapping("/{companyName}")
    public Flux<CompanyDTO> findByName(@PathVariable String companyName) {
        return companyService.findByName(companyName);
    }

    @PostMapping
    public Mono<CompanyDTO> save(@RequestBody CompanyDTO companyDTO) {
        return companyService.save(companyDTO);
    }
}
