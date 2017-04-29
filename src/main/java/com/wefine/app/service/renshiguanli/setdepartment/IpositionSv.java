package com.wefine.app.service.renshiguanli.setdepartment;

import com.wefine.app.core.base.BaseService;
import com.wefine.app.po.StaffPosition;

import java.util.List;

public interface IpositionSv extends BaseService<StaffPosition, String> {
    public List<StaffPosition> selectBydepartmentId(int departmentid);

    public List<StaffPosition> selectBydepartmentIds(int[] departmentids);
}
