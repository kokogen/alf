package koko.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class CompanyDTO {
    private long id;
    private String name;
    private String url;
    private String area;
    private Set<VacancyDTO> vacancies;
}
