package com.wefine.app.service.kaoqinchuli.buqiandenji.Impl;

import com.wefine.app.dao.StaffRetroactiveMapper;
import com.wefine.app.dao.StaffclassperiodsigninrecordMapper;
import com.wefine.app.po.StaffRetroactive;
import com.wefine.app.po.Staffclassperiodsigninrecord;
import com.wefine.app.service.kaoqinchuli.buqiandenji.IdealwihthRetroativeSv;
import com.wefine.app.vo.DealwihthRetroative;
import com.wefine.app.vo.Unusual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("idealwihthRetroativeSv")
public class DealwihthRetroativeImpl implements IdealwihthRetroativeSv {
    @Autowired
    StaffRetroactiveMapper staffRetroactiveDao;
    @Autowired
    StaffclassperiodsigninrecordMapper staffclassperiodsigninrecordDao;

    /**
     * 查询异常信息进行处理
     **/
    public List<Unusual> selectUnusual() {
        return staffRetroactiveDao.selectUnusual();
    }

    /**
     * 处理异常考勤时修改考勤类别
     **/
    public int updateAttendanceType(int staffClassPeriodSignInRecordId,
                                    int attendanceClassChildId) {
        int i = staffRetroactiveDao.updateAttendanceType(staffClassPeriodSignInRecordId, attendanceClassChildId);
        return i;
    }

    /**
     * 查询所有补签申请
     **/
    public List<DealwihthRetroative> selectDealwihthRetroative(int checkStateId) {
        return staffRetroactiveDao.selectDealwihthRetroative(checkStateId);
    }

    /**
     * 修改签到表
     **/
    public int updateStaffclassperiodsigninrecord(Staffclassperiodsigninrecord t) {
        int i = staffclassperiodsigninrecordDao.updateByPrimaryKeySelective(t);
        return i;
    }

    /**
     * 修改补签登记表
     **/
    public int updateStaffretroactive(StaffRetroactive t) {
        int i = staffRetroactiveDao.updateByPrimaryKeySelective(t);
        return i;
    }

}
