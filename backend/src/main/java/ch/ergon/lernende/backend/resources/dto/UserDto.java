package ch.ergon.lernende.backend.resources.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private int points;
    private boolean administrator;

}
