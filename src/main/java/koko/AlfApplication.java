package koko;

import koko.dto.VacancyJobMode;
import koko.dto.VacancyPosition;
import koko.model.Company;
import koko.model.Location;
import koko.model.Vacancy;
import koko.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class AlfApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AlfApplication.class, args);
	}

	@Autowired private CompanyRepository companyRepository;
	//@Autowired private VacancyRepository vacancyRepository;

	@Override
	public void run(String... args) throws Exception {
		Company company = new Company();
		company.setName("Intel");
		company.setArea("Technology");
		company.setUrl("www.intel.com");

		Location location = new Location();
		location.setId("msk");
		location.setName("Moscow");
		location.setCountryName("Russia");

		Vacancy vacancy1 = new Vacancy();
		vacancy1.setPosition(VacancyPosition.ARCHITECT);
		//vacancy1.setCompany(company);
		vacancy1.setSalary(10000);
		vacancy1.setLocation(location);
		vacancy1.setMode(VacancyJobMode.ONSITE);
		vacancy1.setActive(true);
		vacancy1.setDescription("We are looking for an architect!");
		vacancy1.setRequirements("Hadoop, Spark, HBase, Airflow, java");

		Vacancy vacancy2 = new Vacancy();
		vacancy2.setPosition(VacancyPosition.DEVELOPER);
		//vacancy2.setCompany(company);
		vacancy2.setSalary(5000);
		vacancy2.setLocation(location);
		vacancy2.setMode(VacancyJobMode.HYBRID);
		vacancy2.setActive(true);
		vacancy2.setDescription("We are looking for an java developer!");
		vacancy2.setRequirements("java, spring boot, jpa, postgresql");


		company.setVacancies(Set.of(vacancy1, vacancy2));

		Company theCompany = companyRepository.saveAndFlush(company);
		System.out.println("\n");
		System.out.println(theCompany);
	}
}
