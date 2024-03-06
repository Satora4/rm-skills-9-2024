package ch.ergon.lernende.backend.resources;

import ch.ergon.lernende.backend.db.Tables;
import ch.ergon.lernende.backend.resources.dto.UserDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserResource {

    private final DSLContext dsl;

    @Autowired
    public UserResource(DSLContext dsl) {
        this.dsl = dsl;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return dsl.selectFrom(Tables.USER).fetch().stream()
                .map(r -> new UserDto(r.getFirstName(), r.getLastName(), r.getEmail(), r.getPoints(), r.getAdministrator().intValue() != 0 ))
                .toList();
    }
}
