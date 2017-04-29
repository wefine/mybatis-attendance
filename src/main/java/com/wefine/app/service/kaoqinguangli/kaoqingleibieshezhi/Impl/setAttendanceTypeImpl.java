package com.wefine.app.service.kaoqinguangli.kaoqingleibieshezhi.Impl;


import com.wefine.app.dao.AttendanceclasschildMapper;
import com.wefine.app.po.Attendanceclasschild;
import com.wefine.app.service.kaoqinguangli.kaoqingleibieshezhi.IsetAttendanceTypeSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("isetAttendanceTypeSv")
public class setAttendanceTypeImpl implements IsetAttendanceTypeSv {
    @Autowired
    AttendanceclasschildMapper attendanceclasschildDao;

    @Override
    public Attendanceclasschild selectById(int id) {
        return attendanceclasschildDao.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Attendanceclasschild t) {
        return attendanceclasschildDao.insertSelective(t);
    }

    @Override
    public int update(Attendanceclasschild t) {

        return attendanceclasschildDao.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(int id) {
        return attendanceclasschildDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Attendanceclasschild> selectAttendanceById(int id) {
        return attendanceclasschildDao.selectAttendanceById(id);
    }

}
