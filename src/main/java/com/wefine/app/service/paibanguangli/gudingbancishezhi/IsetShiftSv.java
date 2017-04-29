package com.wefine.app.service.paibanguangli.gudingbancishezhi;

import com.wefine.app.core.base.BaseService;
import com.wefine.app.po.Shift;
import com.wefine.app.po.ShiftChild;

import java.util.List;

public interface IsetShiftSv extends BaseService<Shift, String> {
    List<Shift> selectShiftByPositionid(int id);

    int insertAll(Shift t, List<ShiftChild> listChild);
}
