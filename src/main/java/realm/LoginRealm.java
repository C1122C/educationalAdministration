package realm;

import po.Role;
import po.UserLogin;
import service.RoleService;
import service.UserLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;


@Component
public class LoginRealm extends AuthorizingRealm{

    @Resource(name = "userLoginServiceImpl")
    private UserLoginService userLoginService;

    @Resource(name = "roleServiceImpl")
    private RoleService roleService;

    /*授权*/
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) getAvailablePrincipal(principalCollection);
        Role role = null;
        try {
            UserLogin userLogin = userLoginService.findByName(username);
            role = roleService.findById(userLogin.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<String>();
        if (role != null) {
            r.add(role.getRoleName());
            info.setRoles(r);
        }
        return info;
    }

    /*验证*/
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        UserLogin userLogin = null;
        try {
            userLogin = userLoginService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userLogin == null) {
            throw new UnknownAccountException();
        } else if (!password.equals(userLogin.getPassword())) {
            throw new IncorrectCredentialsException();
        }

        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());
        return aInfo;
    }
}
