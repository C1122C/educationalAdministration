package service;

import po.UserLogin;

public interface UserLoginService {

    UserLogin findByName(String name) throws Exception;

    void save(UserLogin userLogin) throws Exception;

    void removeByName(String name) throws Exception;

    void updateByName(String name, UserLogin userLogin);

}
