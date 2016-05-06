package com.netcracker.businesslogic.users;

import com.netcracker.businesslogic.logging.BusinessLogicLogging;
import com.netcracker.businesslogic.support.HashCreator;
import com.netcracker.database.dal.UserFacadeLocal;
import com.netcracker.database.entity.User;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

@Stateful
@LocalBean
public class AuthenticationEJB {

    @EJB(beanName = "UserFacade")
    private UserFacadeLocal userFacade;

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public Result tryAuthenticateUser(String login, String password) {
        try {
            User user = userFacade.findByLogin(login);
            if (user == null || !user.getActual()) {
                return new Result(null, Info.REFUSE);
            }
            String hashSalt = user.getHashSalt();
            HashCreator hashCreator = HashCreator.getDefault();
            HashCreator.Result hashCreatingResult = hashCreator.getHash(password, hashSalt);
            String hash = hashCreatingResult.getPasswordHashString();
            if (hash.equals(user.getPasswordHash())) {
                currentUser = user;
                return new Result(currentUser, Info.SUCCESS);
            } else {
                return new Result(null, Info.REFUSE);
            }
        } catch (Exception exception) {
            BusinessLogicLogging.logger.log(Level.FINE, null, exception);
            return new Result(null, Info.FAIL);
        }
    }
    
    public void logOut() {
        currentUser = null;
    }
    
    public static enum Info {
        SUCCESS,
        REFUSE,
        FAIL
    }
    
    public static class Result {
        private User user;
        private Info info;
        
        public Result(User user, Info info) {
            this.user = user;
            this.info = info;
        }

        public User getUser() {
            return user;
        }

        public Info getInfo() {
            return info;
        }
    }

}