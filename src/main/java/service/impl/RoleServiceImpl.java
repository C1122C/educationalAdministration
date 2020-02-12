package service.impl;

import mapper.RoleMapper;
import po.Role;
import service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;

    public Role findById(Integer id) throws Exception {
        return roleMapper.selectByPrimaryKey(id);
    }
}
