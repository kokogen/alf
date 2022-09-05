package koko.services;

import koko.dto.CompanyDTO;
import koko.repo.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CompanyService.class, CompanyRepository.class, Util.class})
class CompanyServiceTest {
    @Autowired
    CompanyService companyService;

    @Test
    public void save_and_read(){
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setName("Roga and Kopyta");
        companyDTO.setArea("Banking");
        companyDTO.setUrl("http://www.roga_and_kopyta.com/careers");

        assertDoesNotThrow(() -> companyService.save(companyDTO));

        Flux<CompanyDTO> companies = companyService.findByName("Roga and Kopyta");

        assertEquals(1, companies.count().block());

    }
}