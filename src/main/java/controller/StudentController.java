package controller;

import po.*;
import service.CourseService;
import service.SelectedCourseService;
import service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;

    @RequestMapping(value = "/allCourse")
    public String stuCourseShow(Model model, Integer page) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        Integer username = Integer.parseInt((String)subject.getPrincipal());
        List<CourseCustom> list = null;
        PagingVO pagingVO = new PagingVO();
        pagingVO.setTotalCount(courseService.getCountCourse());

        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.stuFindByPaging(1,username);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.stuFindByPaging(page,username);;
        }

        model.addAttribute("courseList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "student/allCourse";
    }

    @RequestMapping(value = "/selectCourse")
    public String stuSelectedCourse(int id) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseId(id);
        selectedCourseCustom.setStudentId(Integer.parseInt(username));

        selectedCourseService.save(selectedCourseCustom);

        return "redirect:/student/selectedCourse";
    }

    @RequestMapping(value = "/dropCourse")
    public String outCourse(int id) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseId(id);
        selectedCourseCustom.setStudentId(Integer.parseInt(username));

        selectedCourseService.remove(selectedCourseCustom);

        return "redirect:/student/selectedCourse";
    }

    @RequestMapping(value = "/selectedCourse")
    public String selectedCourse(Model model) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();
        model.addAttribute("selectedCourseList", list);

        return "/student/selectedCourse";
    }

    @RequestMapping(value = "/overCourse")
    public String overCourse(Model model) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();
        model.addAttribute("overCourseList", list);

        return "/student/overCourse";
    }

    //修改密码
    @RequestMapping(value = "/personalMod")
    public String passwordRest() throws Exception {
        return "student/personalInfo";
    }

    @RequestMapping(value = "/searchCourse")
    public String searchCourse(String findByName, Model model) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        Integer username = Integer.parseInt((String)subject.getPrincipal());
        PagingVO pagingVO = new PagingVO();
        pagingVO.setId(username);
        pagingVO.setName('%'+findByName+'%');
        List<CourseCustom> list = courseService.stuFindByName(pagingVO);

        model.addAttribute("courseList", list);
        return "/student/allCourse";
    }

}
