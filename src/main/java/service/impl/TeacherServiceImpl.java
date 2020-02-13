package service.impl;

import exception.CustomException;
import mapper.CollegeMapper;
import mapper.CourseMapper;
import mapper.TeacherMapper;
import mapper.TeacherMapperCustom;
import po.*;
import service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired(required = false)
    private TeacherMapper teacherMapper;

    @Autowired(required = false)
    private TeacherMapperCustom teacherMapperCustom;

    @Autowired(required = false)
    private CollegeMapper collegeMapper;

    @Autowired(required = false)
    private CourseMapper courseMapper;

    public void updateById(Integer id, TeacherCustom teacherCustom) throws Exception {
        teacherCustom.setUserId(id);
        teacherMapper.updateByPrimaryKey(teacherCustom);
    }

    public void removeById(Integer id) throws Exception {
        CourseExample courseExample = new CourseExample();

        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(id);
        List<Course> list = courseMapper.selectByExample(courseExample);

        if (list.size() != 0) {
            throw new CustomException("请先删除该名老师所教授的课程");
        }

        teacherMapper.deleteByPrimaryKey(id);
    }

    public List<TeacherCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<TeacherCustom> list = teacherMapperCustom.findByPaging(pagingVO);

        return list;
    }

    public Boolean save(TeacherCustom teacherCustom) throws Exception {

        Teacher tea = teacherMapper.selectByPrimaryKey(teacherCustom.getUserId());
        if (tea == null) {
            teacherMapper.insert(teacherCustom);
            return true;
        }
        return false;
    }

    public int getCountTeacher() throws Exception {
        //自定义查询对象
        TeacherExample teacherExample = new TeacherExample();
        //通过criteria构造查询条件
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andUserIdIsNotNull();

        return teacherMapper.countByExample(teacherExample);
    }

    public TeacherCustom findById(Integer id) throws Exception {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        TeacherCustom teacherCustom = null;
        if (teacher != null) {
            teacherCustom = new TeacherCustom();
            BeanUtils.copyProperties(teacher, teacherCustom);
        }

        return teacherCustom;
    }

    public List<TeacherCustom> findByName(String name) throws Exception {
        TeacherExample teacherExample = new TeacherExample();
        //自定义查询条件
        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andUserNameLike("%" + name + "%");

        List<Teacher> list = teacherMapper.selectByExample(teacherExample);

        List<TeacherCustom> teacherCustomList = null;

        if (list != null) {
            teacherCustomList = new ArrayList<TeacherCustom>();
            for (Teacher t : list) {
                TeacherCustom teacherCustom = new TeacherCustom();
                //类拷贝
                BeanUtils.copyProperties(t, teacherCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(t.getCollegeId());
                teacherCustom.setcollegeName(college.getCollegeName());

                teacherCustomList.add(teacherCustom);
            }
        }

        return teacherCustomList;
    }

    public List<TeacherCustom> findAll() throws Exception {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andUserNameIsNotNull();

        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        List<TeacherCustom> teacherCustomsList = null;
        if (list != null) {
            teacherCustomsList = new ArrayList<TeacherCustom>();
            for (Teacher t: list) {
                TeacherCustom teacherCustom = new TeacherCustom();
                BeanUtils.copyProperties(t, teacherCustom);
                teacherCustomsList.add(teacherCustom);
            }
        }
        return teacherCustomsList;
    }
}
