package com.wefine.app.controller.paibanguangli;

import com.alibaba.fastjson.JSON;
import com.wefine.app.core.base.BaseController;
import com.wefine.app.po.Classperiod;
import com.wefine.app.po.Positionclasses;
import com.wefine.app.service.paibanguangli.bancishezhi.IclassperiodSv;
import com.wefine.app.service.paibanguangli.bancishezhi.IsetClassesSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.util.List;


@Controller
@RequestMapping("/SetClasses")
public class SetClasses extends BaseController<Positionclasses, String> {
    @Autowired
    IclassperiodSv iclassperiodSv;
    @Autowired
    IsetClassesSv isetClassesSv;

    @RequestMapping(value = "/selectPositionclasse")
    public void selectPositionclasses(PrintWriter pw) {
        List<Positionclasses> positionclasses = isetClassesSv.selectPositionclasses();
        String str = listToJson(positionclasses);
        pw.write(str);
    }

    /*根据班次id查询班段
     *
     * */
    @ResponseBody
    @RequestMapping(value = "/selectClassePeriod", produces = "text/html;charset=UTF-8")
    public String selectClassperiod(int Classid) {
        List<Classperiod> classperiods = iclassperiodSv.selectClassperiod(Classid);

        return JSON.toJSONString(classperiods);
    }

    /*
     * 根据考勤类别ids查询考勤类别明细绑定到时间段类型下拉框中
     * */
    @ResponseBody
    @RequestMapping(value = "/selectAttendanceByIds", produces = "text/html;charset=UTF-8")
    public String selectAttendanceByIds(int[] ids) {
        return JSON.toJSONString(iclassperiodSv.selectAttendanceByIds(ids));
    }

    /* 修改班次
     *
     * */
    @ResponseBody
    @RequestMapping(value = "/updateClass", produces = "text/html;charset=UTF-8")
    @Override
    public String update(Positionclasses t) {
        int i = isetClassesSv.update(t);
        return "" + i;
    }

    /*新增班次
     *
     * */
    @ResponseBody
    @RequestMapping(value = "/insertPositionclasses", produces = "text/html;charset=UTF-8")
    public String insert(Positionclasses t) {
        return "" + isetClassesSv.insert(t);
    }

    /*根据班次id查找要修改的班次
     *
     * */
    @ResponseBody
    @RequestMapping(value = "/selectClassById", produces = "text/html;charset=UTF-8")
    @Override
    public String selectById(int id) {
        String str = JSON.toJSONString(isetClassesSv.selectById(id));

        return str;
    }

    /*删除班次
     *
     * */
    @ResponseBody
    @RequestMapping(value = "/deleteClass", produces = "text/html;charset=UTF-8")
    @Override
    public String delete(int id) {
        int i = isetClassesSv.delete(id);
        return "" + i;
    }

    @RequestMapping("selectClassUseNo")
    /**查询班次使用数**/
    public void selectClassUseNo(int positionClassesId, PrintWriter pw) {
        int i = isetClassesSv.selectClassUseNo(positionClassesId);
        pw.write("" + i);
    }

    /*新增班段
     *
     * */
    @RequestMapping(value = "/insertClassPeriod", produces = "text/html;charset=UTF-8")
    public void insertClassPeriod(Classperiod t, PrintWriter pw) {
        int i = iclassperiodSv.insert(t);
        pw.write("" + i);
    }

    /*删除班段
     *
     * */
    @RequestMapping(value = "/deleteClassPeriod", produces = "text/html;charset=UTF-8")
    public void deleteClassPeriod(int id, PrintWriter pw) {
        int i = iclassperiodSv.delete(id);
        pw.write("" + i);
    }

    @RequestMapping(value = "/selectByClassPeriodId", produces = "text/html;charset=UTF-8")
    /*查询要修改的班段
     *
	 * */
    public void selectByClassPeriodId(int id, PrintWriter pw) {
        String strPeriod = JSON.toJSONString(iclassperiodSv.selectById(id));

        pw.write(strPeriod);
    }

    @RequestMapping(value = "/updateClassPeriod", produces = "text/html;charset=UTF-8")
    /*保存班段信息
	 *
	 * */
    public void updateClassPeriod(Classperiod t, PrintWriter pw) {
        int i = iclassperiodSv.update(t);
        pw.write("" + i);
    }


    @Override
    public String selectAll() {
        // TODO Auto-generated method stub
        return null;
    }


}
