package Bus;

import DAO.UserDAO;
import DTO.UsersEntity;

import java.util.List;

public class UserBus {

    public List<UsersEntity> usersEntityList(){
        return new UserDAO().getUsers();
    }

    public void logup(UsersEntity user){
        new UserDAO().logupUser(user);
    }

    public boolean userExists(String usernameOrEmail){
        return new UserDAO().userExists(usernameOrEmail);
    }

    public UsersEntity getUserByUsernameOrEmail(String usernameOrEmail){
        return new UserDAO().getUserByUsernameOrEmail(usernameOrEmail);
    }

    public void changePassword(UsersEntity user){
        new UserDAO().changePassword(user);
    }
}
