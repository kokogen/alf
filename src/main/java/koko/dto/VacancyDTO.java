package koko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
