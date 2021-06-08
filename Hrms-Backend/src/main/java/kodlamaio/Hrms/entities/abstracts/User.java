package kodlamaio.Hrms.entities.abstracts;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
