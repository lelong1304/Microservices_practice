package longware.app.web.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountDto {
    private String firstName;

    private String lastName;

    private String email;

    private String accountName;

    private String password;

    private String status;
}
