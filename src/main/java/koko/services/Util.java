package koko.services;

import koko.dto.CompanyDTO;
import koko.dto.LocationDTO;
import koko.dto.VacancyDTO;
import koko.model.Company;
import koko.model.Location;
import koko.model.Vacancy;
import koko.repo.CompanyRepository;
import koko.repo.LocationRepository;
import koko.repo.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class Util {
    @Autowired
    private static VacancyRepository vacancyRepository;
    @Autowired
    private static CompanyRepository companyRepository;
    @Autowired
    private static LocationRepository locationRepository;

    public static VacancyDTO toVacancyDTO(Vacancy vacancy) {
        return VacancyDTO.builder()
                .id(vacancy.getId())
                .companyId(vacancy.getCompany().getId())
                .locationId(vacancy.getLocation().getId())
                .description(vacancy.getDescription())
                .isActive(vacancy.getIsActive())
                .mode(vacancy.getMode())
                .position(vacancy.getPosition())
                .requirements(vacancy.getRequirements())
                .salary(vacancy.getSalary())
                .build();
    }

    public static Vacancy toVacancy(VacancyDTO vacancyDTO) throws IllegalStateException {

        Vacancy vacancy = new Vacancy();
        vacancy.setId(vacancyDTO.getId());
        vacancy.setActive(vacancyDTO.isActive());
        vacancy.setDescription(vacancyDTO.getDescription());
        vacancy.setPosition(vacancyDTO.getPosition());
        vacancy.setRequirements(vacancy.getRequirements());
        vacancy.setMode(vacancyDTO.getMode());
        vacancy.setSalary(vacancyDTO.getSalary());

        locationRepository.findById(vacancyDTO.getLocationId())
                .ifPresentOrElse(
                        vacancy::setLocation,
                        () -> {throw new IllegalStateException("Company wth id = " + vacancyDTO.getLocationId() + "not found.");}
                );

        companyRepository.findById(vacancyDTO.getCompanyId())
                .ifPresentOrElse(
                        vacancy::setCompany,
                        () -> {throw new IllegalStateException("Company wth id = " + vacancyDTO.getCompanyId() + "not found.");}
                );

        //vacancy.getCompany().addVacancy(vacancy);
        return vacancy;
    }

    public static CompanyDTO toCompanyDTO(Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .url(company.getUrl())
                .area(company.getArea())
                .vacancies(company.getVacancies().stream().map(Util::toVacancyDTO).collect(Collectors.toSet()))
                .build();
    }

    public static Company toCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setId(companyDTO.getId());
        company.setName(companyDTO.getName());
        company.setUrl(companyDTO.getUrl());
        company.setArea(companyDTO.getArea());
        company.setVacancies(companyDTO.getVacancies().stream().map(Util::toVacancy).collect(Collectors.toSet()));
        return company;
    }

    public static Location toLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setId(locationDTO.getId());
        location.setName(locationDTO.getName());
        location.setCountryName(locationDTO.getCountryName());
        return location;
    }

    public static LocationDTO toLocationDTO(Location location) {
        return LocationDTO.builder()
                .id(location.getId())
                .name(location.getName())
                .countryName(location.getCountryName())
                .build();
    }
}
