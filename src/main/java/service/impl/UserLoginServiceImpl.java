package service.impl;

import mapper.UserloginMapper;
import po.UserLogin;
import po.UserLoginExample;
import service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired(required = false)
    private UserloginMapper userloginMapper;


    public UserLogin findByName(String name) throws Exception {
        UserLoginExample userLoginExample = new UserLoginExample();

        UserLoginExample.Criteria criteria = userLoginExample.createCriteria();
        criteria.andUserIdEqualTo(name);

        List<UserLogin> list = userloginMapper.selectByExample(userLoginExample);

        return list.get(0);
    }

    public void save(UserLogin userLogin) throws Exception {
        userloginMapper.insert(userLogin);
    }

    public void removeByName(String name) throws Exception {
        UserLoginExample userLoginExample = new UserLoginExample();

        UserLoginExample.Criteria criteria = userLoginExample.createCriteria();
        criteria.andUserIdEqualTo(name);

        userloginMapper.deleteByExample(userLoginExample);
    }

    public void updateByName(String name, UserLogin userLogin) {
        UserLoginExample userLoginExample = new UserLoginExample();

        UserLoginExample.Criteria criteria = userLoginExample.createCriteria();
        criteria.andUserIdEqualTo(name);

        userloginMapper.updateByExample(userLogin, userLoginExample);
    }

}
