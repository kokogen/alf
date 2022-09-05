package koko.model;

import koko.dto.VacancyJobMode;
import koko.dto.VacancyPosition;

import javax.persistence.*;

@Entity
public class Vacancy {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private VacancyPosition position;
    private VacancyJobMode mode;
    private String description;
    private String requirements;
    private int salary;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    private boolean isActive;

    public Location getLocation() {
        return location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public VacancyPosition getPosition() {
        return position;
    }

    public void setPosition(VacancyPosition position) {
        this.position = position;
    }

    public VacancyJobMode getMode() {
        return mode;
    }

    public void setMode(VacancyJobMode mode) {
        this.mode = mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "\nVacancy{" +
                "\n\t  id=" + id +
                "\n\t, company=" + company.getId() +
                "\n\t, position=" + position +
                "\n\t, mode=" + mode +
                "\n\t, description='" + description + '\'' +
                "\n\t, requirements='" + requirements + '\'' +
                "\n\t, salary=" + salary +
                "\n\t, location=" + location +
                "\n\t, isActive=" + isActive +
                "\n\t}";
    }
}
