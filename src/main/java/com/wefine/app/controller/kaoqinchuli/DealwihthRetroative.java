package com.wefine.app.controller.kaoqinchuli;

import com.alibaba.fastjson.JSON;
import com.wefine.app.po.StaffRetroactive;
import com.wefine.app.po.Staffclassperiodsigninrecord;
import com.wefine.app.service.kaoqinchuli.buqiandenji.IdealwihthRetroativeSv;
import com.wefine.app.vo.Unusual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("DealwihthRetroative")
public class DealwihthRetroative {
    @Autowired
    IdealwihthRetroativeSv idealwihthRetroativeSv;

    @RequestMapping("selectUnusual")
    /**查询异常信息进行处理**/
    public void selectUnusual(PrintWriter pw) {
        List<Unusual> list = idealwihthRetroativeSv.selectUnusual();
        String str = JSON.toJSONString(list);
        pw.write(str);
    }

    @RequestMapping("updateAttendanceType")
    /**处理异常考勤时修改考勤类别**/
    public void updateAttendanceType(int staffClassPeriodSignInRecordId,
                                     int attendanceClassChildId, PrintWriter pw) {
        int i = idealwihthRetroativeSv.updateAttendanceType(staffClassPeriodSignInRecordId, attendanceClassChildId);
        pw.write("" + i);
    }

    @RequestMapping("selectDealwihthRetroative")
    /**查询所有补签申请**/
    public void selectDealwihthRetroative(int checkStateId, PrintWriter pw) {
        List<com.wefine.app.vo.DealwihthRetroative> list = idealwihthRetroativeSv.selectDealwihthRetroative(checkStateId);
        String str = JSON.toJSONString(list);
        pw.write(str);
    }

    @RequestMapping("updateStaffclassperiodsigninrecord")
    /**修改签到表**/
    public void updateStaffclassperiodsigninrecord(Staffclassperiodsigninrecord t, PrintWriter pw) {
        int i = idealwihthRetroativeSv.updateStaffclassperiodsigninrecord(t);
        pw.write("" + i);
    }

    @RequestMapping("updateStaffretroactive")
    /**修改补签登记表**/
    public void updateStaffretroactive(StaffRetroactive t, PrintWriter pw) {
        int i = idealwihthRetroativeSv.updateStaffretroactive(t);
        pw.write("" + i);
    }


}
