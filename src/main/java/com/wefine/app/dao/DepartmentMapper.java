package com.wefine.app.dao;

import com.wefine.app.po.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentMapper")
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departmentid);

    List<Department> selectAll();

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}
