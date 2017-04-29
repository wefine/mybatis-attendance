package com.wefine.app.controller.kaoqinguanli;

import com.alibaba.fastjson.JSON;
import com.wefine.app.po.Attendanceclasschild;
import com.wefine.app.service.kaoqinguangli.kaoqingleibieshezhi.IsetAttendanceTypeSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;

@Controller
@RequestMapping("/setAttendanceType")
public class SetAttendanceType {
    @Autowired
    IsetAttendanceTypeSv isetAttendanceTypeSv;


    public String selectByAttendanceTypeId(int attendanceTypeId) {

        return "";
    }

    @RequestMapping("/selectByaAtendancectypeid")
    public void selectByaAtendancectypeid(int id, PrintWriter pw) {
        String str = JSON.toJSONString(isetAttendanceTypeSv.selectAttendanceById(id));

        pw.write(str);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAttendanceclasschild", produces = "text/html;charset=UTF-8")
    public String update(Attendanceclasschild t) {
        int i = isetAttendanceTypeSv.update(t);
        return "" + i;
    }

    @ResponseBody
    @RequestMapping(value = "/insertAttendanceclasschild", produces = "text/html;charset=UTF-8")

    public String insert(Attendanceclasschild t) {
        int i = isetAttendanceTypeSv.insert(t);
        return "" + i;
    }

    @ResponseBody
    @RequestMapping(value = "/selectByChildid", produces = "text/html;charset=UTF-8")
    public String selectById(int id) {
        return JSON.toJSONString(isetAttendanceTypeSv.selectById(id));
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAttendanceclasschild", produces = "text/html;charset=UTF-8")

    public String delete(int id) {
        int i = isetAttendanceTypeSv.delete(id);
        return "" + i;
    }

}
