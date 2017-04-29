package com.wefine.app.service.paibanguangli.gudingbancishezhi;

import com.wefine.app.core.base.BaseService;
import com.wefine.app.po.ShiftChild;

import java.util.List;

public interface IsetShiftChildSv extends BaseService<ShiftChild, String> {
    List<ShiftChild> selectbyShiftId(int id);

    int deleteByShiftId(int shiftid);
}
