package longware.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    protected Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String accountName;

    private String password;

    private String status;
}
