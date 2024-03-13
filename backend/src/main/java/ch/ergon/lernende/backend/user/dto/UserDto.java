package ch.ergon.lernende.backend.user.dto;

import ch.ergon.lernende.backend.db.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private String name;
    private UserRole role;
    private boolean administrator;
}
