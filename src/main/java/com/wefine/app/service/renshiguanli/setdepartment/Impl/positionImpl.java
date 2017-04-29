package com.wefine.app.service.renshiguanli.setdepartment.Impl;

import com.wefine.app.dao.StaffPositionMapper;
import com.wefine.app.po.StaffPosition;
import com.wefine.app.service.renshiguanli.setdepartment.IpositionSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ipositionSv")
public class positionImpl implements IpositionSv {
    @Autowired
    StaffPositionMapper staffPositionDo;

    @Override
    //查询部门职务
    public List<StaffPosition> selectBydepartmentId(int departmentid) {
        List<StaffPosition> staffPositions = staffPositionDo.selectBydepartmentId(departmentid);
        return staffPositions;
    }

    //查询子部门职务
    @Override
    public List<StaffPosition> selectBydepartmentIds(int[] departmentids) {

        return staffPositionDo.selectBydepartmentIds(departmentids);
    }

    @Override
    public StaffPosition selectById(int id) {
        return null;
    }

    @Override
    public int insert(StaffPosition t) {

        return staffPositionDo.insert(t);
    }

    @Override
    public int update(StaffPosition t) {
        return staffPositionDo.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(int id) {
        return staffPositionDo.deleteByPrimaryKey(id);
    }


}
