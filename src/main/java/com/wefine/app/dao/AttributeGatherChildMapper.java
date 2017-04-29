package com.wefine.app.dao;

import com.wefine.app.po.AttributeGatherChild;

import java.util.List;

public interface AttributeGatherChildMapper {
    int deleteByPrimaryKey(Integer attributegatherchildid);

    int insert(AttributeGatherChild record);

    int insertSelective(AttributeGatherChild record);

    AttributeGatherChild selectByPrimaryKey(Integer attributegatherchildid);

    int updateByPrimaryKeySelective(AttributeGatherChild record);

    int updateByPrimaryKey(AttributeGatherChild record);

    //新增的
    List<AttributeGatherChild> selectByAttributeGatherId(int attributeGatherId);
}
