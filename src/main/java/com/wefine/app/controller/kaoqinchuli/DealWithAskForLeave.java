package com.wefine.app.controller.kaoqinchuli;

import com.alibaba.fastjson.JSON;
import com.wefine.app.po.AskForLeave;
import com.wefine.app.service.kaoqinchuli.jiabangongxiudengji.IdealWithAskForLeaveSv;
import com.wefine.app.vo.GengGaiPaiBanList;
import com.wefine.app.vo.MyAskForLeave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("DealWithAskForLeave")
public class DealWithAskForLeave {
    @Autowired
    IdealWithAskForLeaveSv idealWithAskForLeaveSv;

    /**
     * 查询所有员工请假、加班、出差的申请
     **/
    @RequestMapping("selectAllAskForLeave")
    public void selectAllAskForLeave(int checkTypeId, PrintWriter pw) {
        List<MyAskForLeave> myAskForLeaves = idealWithAskForLeaveSv.selectAllAskForLeave(checkTypeId);
        String str = JSON.toJSONString(myAskForLeaves);
        pw.write(str);
    }

    @RequestMapping("updateAskForLeavAandRecord")
    /**修改请假、出差申请信息和修改签到记录表的考勤状态**/
    public void updateAskForLeavAandRecord(AskForLeave askForLeave, PrintWriter pw) {
        int i = idealWithAskForLeaveSv.updateAskForLeavAandRecord(askForLeave);
        pw.write("" + i);
    }

    @RequestMapping("updateAskAndDeleteInsertRecord")
    /**修改加班申请信息和删除签到记录新增签到记录**/
    public void updateAskAndDeleteInsertRecord(AskForLeave askForLeave,
                                               GengGaiPaiBanList listinsert, PrintWriter pw) {
        int i = idealWithAskForLeaveSv.updateAskAndDeleteInsertRecord(askForLeave, listinsert.getListInsert());
        pw.write("" + i);
    }

}
