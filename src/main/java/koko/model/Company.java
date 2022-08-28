package koko.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private String url;
    private String area;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    Set<Vacancy> vacancies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
        this.vacancies.forEach(v -> v.setCompany(this));
    }

    public void addVacancy(Vacancy vacancy) {
        if(vacancies.stream().noneMatch(x -> x.getId() == vacancy.getId())) vacancies.add(vacancy);
    }
}
