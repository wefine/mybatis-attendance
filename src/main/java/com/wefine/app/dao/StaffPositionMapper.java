package com.wefine.app.dao;

import com.wefine.app.po.StaffPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffPositionMapper {
    int deleteByPrimaryKey(Integer staffpositionid);

    int insert(StaffPosition record);

    int insertSelective(StaffPosition record);

    StaffPosition selectByPrimaryKey(Integer staffpositionid);

    int updateByPrimaryKeySelective(StaffPosition record);

    int updateByPrimaryKey(StaffPosition record);

    //新增的
    List<StaffPosition> selectBydepartmentId(@Param("departmentid") int departmentId);

    List<StaffPosition> selectBydepartmentIds(@Param("departmentids") int[] departmentIds);

    //根据机构id查询机构名称编号和职务
    List<StaffPosition> selectByids(@Param("ids") int[] ids);
}
