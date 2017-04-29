package com.wefine.app.service.kaoqinchuli.buqiandenji;

import com.wefine.app.po.StaffRetroactive;
import com.wefine.app.po.Staffclassperiodsigninrecord;
import com.wefine.app.vo.DealwihthRetroative;
import com.wefine.app.vo.Unusual;

import java.util.List;

public interface IdealwihthRetroativeSv {
    /**
     * 查询异常信息进行处理
     **/
    List<Unusual> selectUnusual();

    /**
     * 处理异常考勤时修改考勤类别
     **/
    int updateAttendanceType(int staffClassPeriodSignInRecordId, int attendanceClassChildId);

    /**
     * 查询所有补签申请
     **/
    List<DealwihthRetroative> selectDealwihthRetroative(int checkStateId);

    /**
     * 修改签到表
     **/
    int updateStaffclassperiodsigninrecord(Staffclassperiodsigninrecord t);

    /**
     * 修改补签登记表
     **/
    int updateStaffretroactive(StaffRetroactive t);
}
