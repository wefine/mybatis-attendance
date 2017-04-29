package com.wefine.app.service.paibanguangli.bancishezhi;

import com.wefine.app.core.base.BaseService;
import com.wefine.app.po.Positionclasses;

import java.util.List;

public interface IsetClassesSv extends BaseService<Positionclasses, String> {
    /**
     * 查询班次
     **/
    public List<Positionclasses> selectPositionclasses();

    /**
     * 查询班次和班段信息
     **/
    public List<Positionclasses> selectClass();

    /**
     * 查询该班次是否正在使用中
     **/
    int selectClassUseNo(int positionClassesId);

}
