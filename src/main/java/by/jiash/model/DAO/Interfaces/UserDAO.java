package by.jiash.model.DAO.Interfaces;
import by.jiash.DTO.EditInfoRequest;
import by.jiash.DTO.LogInRequest;
import by.jiash.DTO.RegistrationRequest;
import by.jiash.model.Entities.User;
public interface UserDAO {
    User registrationUser(RegistrationRequest registrationRequest);
    User enterInSystem(LogInRequest logInRequest);
    User updateInfo(EditInfoRequest editInfoRequest);
}
