package mapper;

import po.UserLoginCustom;

public interface UserloginMapperCustom {

    UserLoginCustom findOneByName(String name) throws Exception;

}
