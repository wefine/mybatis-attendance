package com.wefine.app.service.paibanguangli.bancishezhi;

import com.wefine.app.core.base.BaseService;
import com.wefine.app.po.Attendanceclasschild;
import com.wefine.app.po.Classperiod;

import java.util.List;

public interface IclassperiodSv extends BaseService<Classperiod, String> {
    //根据班次id查询班段
    public List<Classperiod> selectClassperiod(int Classid);

    //根据考勤类别ids查询考勤类别明细
    public List<Attendanceclasschild> selectAttendanceByIds(int[] ids);

}
