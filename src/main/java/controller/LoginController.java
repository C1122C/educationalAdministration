package controller;

import po.UserLogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    //登录跳转
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../../login";
    }

    //登录表单处理
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    //@ResponseBody
    public String login(UserLogin userLogin) throws Exception {
        System.out.println("ID:"+userLogin.getUserId());
        UsernamePasswordToken token = new UsernamePasswordToken(userLogin.getUserId(),
                userLogin.getPassword());
        Subject subject = SecurityUtils.getSubject();

        subject.login(token);

        if (subject.hasRole("admin")) {
            System.out.println("admin log in");
            return "redirect:/admin/showStudent";
        } else if (subject.hasRole("teacher")) {
            System.out.println("teacher log in");
            return "redirect:/teacher/showCourse";
        } else if (subject.hasRole("student")) {
            System.out.println("student log in");
            return "redirect:/student/showCourse";
        }
        System.out.println("unauthc");
        return "/login";
    }

}
