package com.wefine.app.service.renshiguanli.setdepartment.Impl;

import com.wefine.app.dao.AttributeGatherChildMapper;
import com.wefine.app.dao.DepartmentMapper;
import com.wefine.app.po.AttributeGatherChild;
import com.wefine.app.po.Department;
import com.wefine.app.service.renshiguanli.setdepartment.IdepartmentSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("idepartmentSv")
public class departmentImpl implements IdepartmentSv {
    @Autowired
    DepartmentMapper departmentDo;
    @Autowired
    AttributeGatherChildMapper attributeGatherChildDo;

    public List<Department> selectAll() {
        List<Department> departments = departmentDo.selectAll();
        return departments;
    }

    public Department selectById(int id) {
        Department dp = departmentDo.selectByPrimaryKey(id);
        return null;
    }

    public int insert(Department t) {
        int i = departmentDo.insert(t);
        return i;
    }


    public int update(Department t) {
        int i = departmentDo.updateByPrimaryKey(t);
        return i;
    }


    public int delete(int id) {
        int i = departmentDo.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public List<AttributeGatherChild> selectByAttributeGatherId(
        int attributeGatherId) {
        return attributeGatherChildDo.selectByAttributeGatherId(attributeGatherId);
    }


}
