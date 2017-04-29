package com.wefine.app.dao;

import com.wefine.app.po.Shift;

import java.util.List;

public interface ShiftMapper {
    int deleteByPrimaryKey(Integer shiftid);

    int insert(Shift record);

    int insertSelective(Shift record);

    Shift selectByPrimaryKey(Integer shiftid);

    int updateByPrimaryKeySelective(Shift record);

    int updateByPrimaryKey(Shift record);

    /*新增的*/
    List<Shift> selectShiftByPositionid(int id);
}
