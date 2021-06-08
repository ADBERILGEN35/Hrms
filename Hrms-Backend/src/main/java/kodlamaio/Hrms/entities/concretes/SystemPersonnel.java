package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.Hrms.entities.abstracts.Entities;
import kodlamaio.Hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id")
@Data
@Entity
@Table(name = "system_personnel")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SystemPersonnel extends User implements Entities {

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    public SystemPersonnel(int departmentId, String email, String password, String firstName, String lastName) {
        super(email, password);
        this.departmentId = departmentId;
        this.first_name = firstName;
        this.last_name = lastName;
    }
}

