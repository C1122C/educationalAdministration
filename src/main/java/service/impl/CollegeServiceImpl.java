package service.impl;

import mapper.CollegeMapper;
import po.College;
import po.CollegeExample;
import service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired(required = false)
    private CollegeMapper collegeMapper;

    public List<College> finAll() throws Exception {
        CollegeExample collegeExample = new CollegeExample();
        CollegeExample.Criteria criteria = collegeExample.createCriteria();

        criteria.andCollegeIdIsNotNull();


        return collegeMapper.selectByExample(collegeExample);
    }
}
