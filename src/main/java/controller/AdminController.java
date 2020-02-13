package controller;

import exception.CustomException;
import po.*;
import service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "collegeServiceImpl")
    private CollegeService collegeService;

    @Resource(name = "userLoginServiceImpl")
    private UserLoginService userLoginService;

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<学生操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    @RequestMapping("/showStudent")
    public String showStudent(Model model, Integer page) throws Exception {
        List<StudentCustom> list = null;
        PagingVO pagingVO = new PagingVO();
        pagingVO.setTotalCount(studentService.getCountStudent());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = studentService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = studentService.findByPaging(page);
        }

        model.addAttribute("studentList", list);
        model.addAttribute("pagingVO", pagingVO);
        return "admin/showStudent";

    }

    @RequestMapping(value = "/addStudent", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {
        List<College> list = collegeService.finAll();
        model.addAttribute("collegeList", list);
        return "admin/addStudent";
    }

    @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
    public String addStudent(StudentCustom studentCustom, Model model) throws Exception {
        Boolean result = studentService.save(studentCustom);
        if (!result) {
            model.addAttribute("message", "学号重复");
            return "error";
        }
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(studentCustom.getUserId().toString());
        userLogin.setPassword("123");
        userLogin.setRole(2);
        userLoginService.save(userLogin);

        return "redirect:/admin/showStudent";
    }

    @RequestMapping(value = "/editStudent", method = {RequestMethod.GET})
    public String editStudentUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/admin/showStudent";
        }
        StudentCustom studentCustom = studentService.findById(id);
        if (studentCustom == null) {
            throw new CustomException("未找到该名学生");
        }
        List<College> list = collegeService.finAll();

        model.addAttribute("collegeList", list);
        model.addAttribute("student", studentCustom);
        return "admin/editStudent";
    }

    @RequestMapping(value = "/editStudent", method = {RequestMethod.POST})
    public String editStudent(StudentCustom studentCustom) throws Exception {
        studentService.adUpdateById(studentCustom.getUserId(), studentCustom);
        return "redirect:/admin/showStudent";
    }

    @RequestMapping(value = "/removeStudent", method = {RequestMethod.GET} )
    public String removeStudent(Integer id) throws Exception {
        if (id == null) {
            return "admin/showStudent";
        }
        studentService.removeById(id);
        userLoginService.removeByName(id.toString());
        return "redirect:/admin/showStudent";
    }

    @RequestMapping(value = "searchStudent", method = {RequestMethod.POST})
    public String searchStudent(String findByName, Model model) throws Exception {
        List<StudentCustom> list = studentService.findByName(findByName);
        model.addAttribute("studentList", list);
        return "admin/showStudent";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<教师操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    @RequestMapping("/showTeacher")
    public String showTeacher(Model model, Integer page) throws Exception {
        List<TeacherCustom> list = null;
        PagingVO pagingVO = new PagingVO();
        pagingVO.setTotalCount(teacherService.getCountTeacher());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = teacherService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = teacherService.findByPaging(page);
        }

        model.addAttribute("teacherList", list);
        model.addAttribute("pagingVO", pagingVO);
        return "admin/showTeacher";
    }

    @RequestMapping(value = "/addTeacher", method = {RequestMethod.GET})
    public String addTeacherUI(Model model) throws Exception {
        List<College> list = collegeService.finAll();
        model.addAttribute("collegeList", list);
        return "admin/addTeacher";
    }

    @RequestMapping(value = "/addTeacher", method = {RequestMethod.POST})
    public String addTeacher(TeacherCustom teacherCustom, Model model) throws Exception {
        Boolean result = teacherService.save(teacherCustom);
        if (!result) {
            model.addAttribute("message", "工号重复");
            return "error";
        }
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(teacherCustom.getUserId().toString());
        userLogin.setPassword("123");
        userLogin.setRole(1);
        userLoginService.save(userLogin);

        return "redirect:/admin/showTeacher";
    }

    @RequestMapping(value = "/editTeacher", method = {RequestMethod.GET})
    public String editTeacherUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/admin/showTeacher";
        }
        TeacherCustom teacherCustom = teacherService.findById(id);
        if (teacherCustom == null) {
            throw new CustomException("未找到该名教师");
        }
        List<College> list = collegeService.finAll();

        model.addAttribute("collegeList", list);
        model.addAttribute("teacher", teacherCustom);

        return "admin/editTeacher";
    }

    @RequestMapping(value = "/editTeacher", method = {RequestMethod.POST})
    public String editTeacher(TeacherCustom teacherCustom) throws Exception {
        teacherService.adUpdateById(teacherCustom.getUserId(), teacherCustom);
        return "redirect:/admin/showTeacher";
    }

    @RequestMapping("/removeTeacher")
    public String removeTeacher(Integer id) throws Exception {
        if (id == null) {
            return "admin/showTeacher";
        }
        teacherService.removeById(id);
        userLoginService.removeByName(id.toString());

        return "redirect:/admin/showTeacher";
    }


    @RequestMapping(value = "searchTeacher", method = {RequestMethod.POST})
    public String searchTeacher(String findByName, Model model) throws Exception {
        List<TeacherCustom> list = teacherService.findByName(findByName);
        model.addAttribute("teacherList", list);
        return "admin/showTeacher";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<课程操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    @RequestMapping("/showCourse")
    public String showCourse(Model model, Integer page) throws Exception {
        List<CourseCustom> list = null;
        PagingVO pagingVO = new PagingVO();
        pagingVO.setTotalCount(courseService.getCountCourse());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }

        model.addAttribute("courseList", list);
        model.addAttribute("pagingVO", pagingVO);
        return "admin/showCourse";
    }

    @RequestMapping(value = "/addCourse", method = {RequestMethod.GET})
    public String addCourseUI(Model model) throws Exception {
        List<TeacherCustom> list = teacherService.findAll();
        List<College> collegeList = collegeService.finAll();
        model.addAttribute("collegeList", collegeList);
        model.addAttribute("teacherList", list);

        return "admin/addCourse";
    }

    @RequestMapping(value = "/addCourse", method = {RequestMethod.POST})
    public String addCourse(CourseCustom courseCustom, Model model) throws Exception {
        Boolean result = courseService.save(courseCustom);
        if (!result) {
            model.addAttribute("message", "课程号重复");
            return "error";
        }
        return "redirect:/admin/showCourse";
    }

    @RequestMapping(value = "/searchCourse")
    public String searchCourse(String findByName, Model model) throws Exception {

        List<CourseCustom> list = courseService.findByName(findByName);

        model.addAttribute("courseList", list);
        return "admin/showCourse";
    }

    @RequestMapping(value = "/editCourse", method = {RequestMethod.GET})
    public String editCourseUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/admin/showCourse";
        }
        CourseCustom courseCustom = courseService.findById(id);
        if (courseCustom == null) {
            throw new CustomException("未找到该课程");
        }
        List<TeacherCustom> list = teacherService.findAll();
        List<College> collegeList = collegeService.finAll();
        model.addAttribute("teacherList", list);
        model.addAttribute("collegeList", collegeList);
        model.addAttribute("course", courseCustom);

        return "admin/editCourse";
    }


    @RequestMapping(value = "/editCourse", method = {RequestMethod.POST})
    public String editCourse(CourseCustom courseCustom) throws Exception {
        courseService.updateById(courseCustom.getCourseId(), courseCustom);
        return "redirect:/admin/showCourse";
    }


    @RequestMapping("/removeCourse")
    public String removeCourse(Integer id) throws Exception {
        if (id == null) {
            return "admin/showCourse";
        }
        courseService.removeById(id);
        return "redirect:/admin/showCourse";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<其他操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    @RequestMapping("/userPasswordRest")
    public String userPasswordRestUI() throws Exception {
        return "admin/userPasswordRest";
    }

    @RequestMapping(value = "/userPasswordRest", method = {RequestMethod.POST})
    public String userPasswordRest(String userName,String password) throws Exception {
        UserLogin u = userLoginService.findByName(userName);
        if (u != null) {
            u.setPassword(password);
            userLoginService.updateByName(userName, u);
        } else {
            throw new CustomException("没找到该用户");
        }
        return "admin/userPasswordRest";
    }

}
