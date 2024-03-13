package ch.ergon.lernende.backend.user;

import ch.ergon.lernende.backend.user.dto.UserDto;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

import static ch.ergon.lernende.backend.db.Tables.*;

@Repository
public class UserRepository {

    private final DSLContext dsl;

    @Autowired
    public UserRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<UserDto> getAllUser() {
        return dsl.selectFrom(USER).fetch().stream()
                .map(r -> new UserDto(r.getName(), r.getRole(), r.getAdministrator().intValue() != 0 ))
                .toList();
    }

    public UserDto createUser(UserDto userDto) {
        dsl.insertInto(USER)
                .set(USER.NAME, userDto.getName())
                .set(USER.ROLE, userDto.getRole())
                .set(USER.ADMINISTRATOR, userDto.isAdministrator() ? (byte) 1 : (byte) 0)
                .execute();
        return userDto;
    }

    public UserDto editUser(UserDto userDto, String id) {
        dsl.update(USER)
                .set(USER.NAME, userDto.getName())
                .set(USER.ROLE, userDto.getRole())
                .set(USER.ADMINISTRATOR, userDto.isAdministrator() ? (byte) 1 : (byte) 0)
                .where(USER.USER_ID.eq(ULong.valueOf(id)))
                .execute();
        return userDto;
    }

    public HttpStatus deleteUser(Long id) {
        dsl.deleteFrom(USER).where(USER.USER_ID.eq(ULong.valueOf(id))).execute();
        return HttpStatus.OK;
    }
}
