package controller;

import exception.CustomException;
import po.*;
import service.CourseService;
import service.SelectedCourseService;
import service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;

    @RequestMapping(value = "/showCourse")
    public String stuCourseShow(Model model) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        List<CourseCustom> list = courseService.findByTeacherID(Integer.parseInt(username));
        model.addAttribute("courseList", list);

        return "teacher/showCourse";
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
        return "teacher/showCourse";
    }

    @RequestMapping(value = "/showGrade")
    public String gradeCourse(Integer id, Model model) throws Exception {
        if (id == null) {
            return "";
        }
        List<SelectedCourseCustom> list = selectedCourseService.findByCourseID(id);
        model.addAttribute("selectedCourseList", list);
        return "teacher/showGrade";
    }

    @RequestMapping(value = "/mark", method = {RequestMethod.GET})
    public String markUI(SelectedCourseCustom scc, Model model) throws Exception {

        SelectedCourseCustom selectedCourseCustom = selectedCourseService.findOne(scc);

        model.addAttribute("selectedCourse", selectedCourseCustom);

        return "teacher/mark";
    }


    @RequestMapping(value = "/mark", method = {RequestMethod.POST})
    public String mark(SelectedCourseCustom scc) throws Exception {

        selectedCourseService.updateOne(scc);

        return "redirect:/teacher/showGrade?id="+scc.getCourseId();
    }

    @RequestMapping(value = "/personalInfo")
    public String personalInfo(Model model) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        Integer id = Integer.parseInt((String)subject.getPrincipal());
        TeacherCustom teacherCustom = teacherService.findById(id);
        if (teacherCustom == null) {
            throw new CustomException("未找到该名教师");
        }

        model.addAttribute("teacher",teacherCustom);
        return "teacher/personalInfo";
    }

    @RequestMapping(value = "/editInfo", method = {RequestMethod.POST})
    public String editStudent(TeacherCustom teacherCustom) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        Integer id = Integer.parseInt((String)subject.getPrincipal());
        teacherService.updateById(id, teacherCustom);

        return "redirect:/teacher/personalInfo";
    }
}
