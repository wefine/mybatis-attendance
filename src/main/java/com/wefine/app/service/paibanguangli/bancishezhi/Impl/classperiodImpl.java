package com.wefine.app.service.paibanguangli.bancishezhi.Impl;

import com.wefine.app.dao.AttendanceclasschildMapper;
import com.wefine.app.dao.ClassperiodMapper;
import com.wefine.app.po.Attendanceclasschild;
import com.wefine.app.po.Classperiod;
import com.wefine.app.service.paibanguangli.bancishezhi.IclassperiodSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("iclassperiodSv")
public class classperiodImpl implements IclassperiodSv {
    @Autowired
    ClassperiodMapper classperiodDao;
    @Autowired
    AttendanceclasschildMapper attendanceclasschildDao;

    @Override
    public Classperiod selectById(int id) {
        Classperiod classperiod = classperiodDao.selectByPrimaryKey(id);
        return classperiod;
    }

    @Override
    public int insert(Classperiod t) {
        int i = classperiodDao.insertSelective(t);
        classperiodDao.insertByClassPeriodId(t.getPositionclassesid(), t.getAttendanceclasschildid(), t.getClassperiodid());
        return i;
    }

    @Override
    public int update(Classperiod t) {
        int i = classperiodDao.deleteByPrimaryKey(t.getClassperiodid());
        int one = t.getClassperiodid();
        classperiodDao.insertSelective(t);
        int tow = t.getClassperiodid();
        classperiodDao.updateSignrecordClassPeriodId(one, tow);
        return i;
    }

    @Override
    public int delete(int id) {
        int i = classperiodDao.deleteByPrimaryKey(id);
        classperiodDao.deleteByClassPeriodId(id);
        return i;
    }

    @Override
    public List<Classperiod> selectClassperiod(int Classid) {
        List<Classperiod> classperiods = classperiodDao.selectClassperiod(Classid);
        return classperiods;
    }

    @Override
    public List<Attendanceclasschild> selectAttendanceByIds(int[] ids) {
        List<Attendanceclasschild> list = attendanceclasschildDao.selectAttendanceByIds(ids);
        return list;
    }

}
