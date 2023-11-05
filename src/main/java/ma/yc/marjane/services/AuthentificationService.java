package ma.yc.marjane.services;

import ma.yc.marjane.dto.UserDto;

public interface AuthentificationService {
    public UserDto login(UserDto userDto);
    public boolean logout();

    UserDto register(UserDto userDto);
}
