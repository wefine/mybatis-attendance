package com.wefine.app.controller.gerenkaoqinxinxi;

import com.alibaba.fastjson.JSON;
import com.wefine.app.po.AskForLeave;
import com.wefine.app.po.Positionclasses;
import com.wefine.app.po.StaffRetroactive;
import com.wefine.app.po.Staffclassperiodsigninrecord;
import com.wefine.app.service.gerenkaoqinxinxi.IpersonAttendanceSv;
import com.wefine.app.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.List;

import static com.wefine.app.util.JU.listToJson;

@Controller
@RequestMapping("PersonAttendance")
public class PersonAttendance {
    @Resource
    private IpersonAttendanceSv ipersonAttendanceSv;

    /**
     * 查询我的班次信息
     **/
    @RequestMapping("selectMyClass")
    public void selectPersonClass(String beginDate, String endDate,
                                  int staffid, PrintWriter pw) {
        List<MyClass> myClasses = ipersonAttendanceSv.selectPersonClass(beginDate, endDate, staffid);
        String str = JSON.toJSONString(myClasses);
        pw.write(str);
    }

    @RequestMapping("selectPunchCard")
    public void selectPunchCard(String workDate, int staffId, PrintWriter pw) {
        List<PunchCard> punchCards = ipersonAttendanceSv.selectPunchCard(workDate, staffId);
        String str = JSON.toJSONString(punchCards);
        pw.write(str);
    }

    /**
     * 正常班次的签到
     **/
    @RequestMapping("updateClassperiodsigninrecord")
    public void updateClassperiodsigninrecord(Staffclassperiodsigninrecord staffclassperiodsigninrecord, PrintWriter pw) {
        int i = ipersonAttendanceSv.updateClassperiodsigninrecord(staffclassperiodsigninrecord);
        pw.write("" + i);
    }

    /**
     * 新增不定时班次签到记录
     **/
    @RequestMapping("insertClassperiodsigninrecord")
    public void insertClassperiodsigninrecord(Staffclassperiodsigninrecord staffclassperiodsigninrecord) {
        ipersonAttendanceSv.insertClassperiodsigninrecord(staffclassperiodsigninrecord);
    }

    /**
     * 新增请假、出差
     **/
    @RequestMapping("insertAskForLeave")
    public void insertAskForLeave(AskForLeave askforleave, PrintWriter pw) {
        int i = ipersonAttendanceSv.insertAskForLeave(askforleave);
        pw.write("" + i);
    }

    /**
     * 新增申请加班的班次
     **/
    @RequestMapping("insertAskForLeaveMx")
    public void insertJiaBan(AskForLeave askforleave, int classid, PrintWriter pw) {
        int i = ipersonAttendanceSv.insertJiaBan(askforleave, classid);
        pw.write("" + i);
    }

    /**
     * 查询加班请假等信息
     **/
    @RequestMapping("selectMyAskForLeave")
    public void selectMyAskForLeave(int staffid, String startDate, String endDate, int checkTypeId, int registrationTypeId, PrintWriter pw) {
        List<MyAskForLeave> list = ipersonAttendanceSv.selectAskForLeave(staffid, startDate, endDate, checkTypeId, registrationTypeId);
        String str = listToJson(list);
        pw.write(str);

    }

    /**
     * 根据加班类别查询班组中对应的班次
     **/
    @RequestMapping("selectClassByAttendanceClassChildId")
    public void selectClassByAttendanceClassChildId(int staffId, int attendanceClassChildId, PrintWriter pw) {
        List<Positionclasses> list = ipersonAttendanceSv.selectClassByAttendanceClassChildId(staffId, attendanceClassChildId);
        String str = listToJson(list);
        pw.write(str);
    }

    /**
     * 根据加班类别查询班组中对应的班次
     **/
    @RequestMapping("updateByAskForLeaveMxId")
    public void updateByAskForLeaveMxId(AskForLeave askforleave, int positionClassesId,
                                        int askForLeaveMxId, PrintWriter pw) {
        int i = ipersonAttendanceSv.updateByAskForLeaveMxId(askforleave, positionClassesId, askForLeaveMxId);
        pw.write("" + i);
    }

    /**
     * 修改请假、出差、加班的申请信息
     **/
    @RequestMapping("updateAskForLeave")
    public void updateAskForLeave(AskForLeave askforleave, PrintWriter pw) {
        int i = ipersonAttendanceSv.updateAskForLeave(askforleave);
        pw.write("" + i);
    }

    /**
     * 根据加班类别查询班组中对应的班次
     **/
    @RequestMapping("deleteByAskForLeaveMxId")
    public void deleteByAskForLeaveMxId(int askForLeaveId, int askForLeaveMxId, PrintWriter pw) {
        int i = ipersonAttendanceSv.deleteByAskForLeaveMxId(askForLeaveId, askForLeaveMxId);
        pw.write("" + i);
    }

    /**
     * 查询我的考勤记录之出差请假
     **/
    @RequestMapping("selectChuChaQingJia")
    public void selectChuChaQingJia(String starDate,
                                    String endDate, int[] staffids, PrintWriter pw) {
        List<ChuChaQingJiaTongJi> list = ipersonAttendanceSv.selectChuChaQingJia(starDate, endDate, staffids);
        String str = listToJson(list);
        pw.write(str);
    }

    /**
     * 查询我的考勤记录之出勤、加班、公休
     **/
    @RequestMapping("selectChuQingJiaBanGongXiuTongJi")
    public void selectChuQingJiaBanGongXiuTongJi(
        String starDate, String endDate, int[] staffids, PrintWriter pw) {
        List<ChuQinJiaBanGongXiuTongJiVo> list = ipersonAttendanceSv.selectChuQingJiaBanGongXiuTongJi(starDate, endDate, staffids);
        String str = listToJson(list);
        pw.write(str);
    }

    /**
     * 新增补签登记记录
     **/
    @RequestMapping("insertStaffretroactive")
    public void insertStaffretroactive(StaffRetroactive staffretroactive, PrintWriter pw) {
        int i = ipersonAttendanceSv.insertStaffretroactive(staffretroactive);
        pw.write("" + i);
    }

    /**
     * 查询班段申请补签记录
     **/
    @RequestMapping("selectRecord")
    public void selectRecord(int staffClassesChildRecordId, boolean toAndFrom, PrintWriter pw) {
        List<StaffRetroactive> list = ipersonAttendanceSv.selectRecord(staffClassesChildRecordId, toAndFrom);
        String str = listToJson(list);
        pw.write(str);
    }

    /**
     * 多条件查询我的所有补签申请
     */
    @RequestMapping("selectMyRetroactive")
    public void selectMyRetroactive(int staffid, String starDate,
                                    String endDate, int checkTypeId, PrintWriter pw) {
        List<StaffRetroactive> list = ipersonAttendanceSv.selectMyRetroactive(staffid, starDate, endDate, checkTypeId);
        String str = listToJson(list);
        pw.write(str);
    }

}
