package longware.app.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "account_id_seq")
    protected Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

}
