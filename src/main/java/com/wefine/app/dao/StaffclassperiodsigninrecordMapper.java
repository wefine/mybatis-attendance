package com.wefine.app.dao;

import com.wefine.app.po.Staffclassperiodsigninrecord;

public interface StaffclassperiodsigninrecordMapper {
    int deleteByPrimaryKey(Integer staffclassperiodsigninrecordid);

    int insert(Staffclassperiodsigninrecord record);

    int insertSelective(Staffclassperiodsigninrecord record);

    Staffclassperiodsigninrecord selectByPrimaryKey(Integer staffclassperiodsigninrecordid);

    int updateByPrimaryKeySelective(Staffclassperiodsigninrecord record);

    int updateByPrimaryKey(Staffclassperiodsigninrecord record);

}
