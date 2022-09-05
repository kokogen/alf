package koko.repo;

import koko.model.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository repository;

    @Test
    public void save(){
        Company company = new Company();
        company.setName("Intel");
        company.setArea("Technology");
        company.setUrl("www.intel.com");

        Company theCompany = repository.save(company);

        Assertions.assertEquals(company.getName(), theCompany.getName());
    }

}
