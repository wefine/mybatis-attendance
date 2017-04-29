package com.wefine.app.controller.paibanguangli;

import com.alibaba.fastjson.JSON;
import com.wefine.app.po.Shift;
import com.wefine.app.po.ShiftChild;
import com.wefine.app.service.paibanguangli.gudingbancishezhi.IsetShiftChildSv;
import com.wefine.app.service.paibanguangli.gudingbancishezhi.IsetShiftSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/SetShift")
public class SetShift {
    @Autowired
    IsetShiftSv isetShiftSv;
    @Autowired
    IsetShiftChildSv isetShiftChildSv;

    @RequestMapping("/selectShift")
    public String selectAll() {
        return "/paibanguangli/gudingbancishezhi/setShift";
    }

    /*  根据职务id查询固定轮班名称*/
    @RequestMapping("/selectShiftByPositionid")
    public void selectShiftByPositionid(int id, PrintWriter pw) {
        List<Shift> shifts = isetShiftSv.selectShiftByPositionid(id);
        String str = JSON.toJSONString(shifts);
        pw.write(str);
    }

    /*新增固定轮班名称和明细*/
    @RequestMapping(value = "/insertShiftAndChild")
    public void insertAll(String t, String listChild, PrintWriter pw) {
        Shift shift = JSON.parseObject(t, Shift.class);

        List<ShiftChild> shiftChilds = JSON.parseArray(listChild, ShiftChild.class);
        int i = isetShiftSv.insertAll(shift, shiftChilds);
        pw.write("" + i);
    }

    /* 根据固定轮班id查询固定轮班明细*/
    @RequestMapping(value = "/selectShiftChildByShiftid")
    public void selectShiftChildByShiftid(int shiftid, PrintWriter pw) {
        List<ShiftChild> shiftChilds = isetShiftChildSv.selectbyShiftId(shiftid);
        String str = JSON.toJSONString(shiftChilds);
        pw.write(str);
    }

    /*删除固定轮班和明细*/
    @RequestMapping(value = "/deleteShiftAndChild")
    public void deleteShiftAndChild(int shiftid, PrintWriter pw) {
        int i = isetShiftSv.delete(shiftid);
        pw.write("" + i);
    }

    /* 修改固定轮班*/
    @RequestMapping(value = "/updateShift")
    public void updateShift(Shift t, PrintWriter pw) {
        int i = isetShiftSv.update(t);
        pw.write("" + i);
    }

    /* 修改固定轮班明细*/
    @RequestMapping(value = "/updateShiftChild")
    public void updateShiftChild(ShiftChild t, PrintWriter pw) {
        int i = isetShiftChildSv.update(t);
        pw.write("" + i);
    }

}
