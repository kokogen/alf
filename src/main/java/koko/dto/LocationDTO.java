package koko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class LocationDTO {
    private String id;
    private String name;
    private String countryName;
}
