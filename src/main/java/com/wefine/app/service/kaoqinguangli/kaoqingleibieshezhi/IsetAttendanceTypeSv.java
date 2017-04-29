package com.wefine.app.service.kaoqinguangli.kaoqingleibieshezhi;

import com.wefine.app.core.base.BaseService;
import com.wefine.app.po.Attendanceclasschild;

import java.util.List;

public interface IsetAttendanceTypeSv extends BaseService<Attendanceclasschild, String> {
    List<Attendanceclasschild> selectAttendanceById(int id);
}
