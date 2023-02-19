package accounts;

import dbService.DBException;
import dbService.DBService;
import org.hibernate.HibernateException;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    DBService dbService;

    public AccountService(DBService dbService) {
        if (dbService == null)
            this.dbService = new DBService();
        else
            this.dbService = dbService;
    }

    public void addNewUser(String login, String pass) {
        try {
            dbService.addUser(login, pass);
        } catch (DBException e) {
            System.out.println("Error");
        }
    }

    public void addNewUser(String login) {
        try {
            dbService.addUser(login, login);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPassLogin(String login, String pass) {
        try {
            if (dbService.getUser(login).getPassword().equals(pass))
                return true;
        } catch (HibernateException | DBException e) {
            e.printStackTrace();
        }
        return false;
    }
}