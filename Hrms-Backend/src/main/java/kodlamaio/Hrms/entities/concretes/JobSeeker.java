package kodlamaio.Hrms.entities.concretes;

import javax.persistence.*;

import kodlamaio.Hrms.entities.abstracts.Entities;
import kodlamaio.Hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@PrimaryKeyJoinColumn(name = "user_id")
@Data
@Entity
@Table(name = "job_seekers")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User implements Entities {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "birth_year")
    private int birthYear;

    @OneToMany(mappedBy = "jobSeeker")
    private List<CurriculumVitae> curriculumVitaes;

    public JobSeeker(String email, String password, String first_name, String last_name, String identification_number, int birth_year) {
        super(email, password);
        this.firstName = first_name;
        this.lastName = last_name;
        this.identificationNumber = identification_number;
        this.birthYear = birth_year;
    }

}

