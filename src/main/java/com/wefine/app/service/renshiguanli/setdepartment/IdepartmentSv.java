package com.wefine.app.service.renshiguanli.setdepartment;

import com.wefine.app.core.base.BaseService;
import com.wefine.app.po.AttributeGatherChild;
import com.wefine.app.po.Department;

import java.util.List;

public interface IdepartmentSv extends BaseService<Department, String> {
    public List<Department> selectAll();

    //根据属性集合id查询明细信息
    public List<AttributeGatherChild> selectByAttributeGatherId(int attributeGatherId);
}
