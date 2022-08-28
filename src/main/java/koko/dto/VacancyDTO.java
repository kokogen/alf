package koko.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VacancyDTO {
    private long id;
    private long companyId;
    private VacancyPosition position;
    private VacancyJobMode mode;
    private String description;
    private String requirements;
    private int salary;
    private String locationId;
    private boolean isActive;
}
