package com.wefine.app.controller.renshiguanli;

import com.alibaba.fastjson.JSON;
import com.wefine.app.core.base.BaseController;
import com.wefine.app.core.query.CommonMethod;
import com.wefine.app.po.Staff;
import com.wefine.app.service.renshiguanli.setdepartment.IdepartmentSv;
import com.wefine.app.service.renshiguanli.setdepartment.IpositionSv;
import com.wefine.app.service.renshiguanli.staff.IstaffSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class staff extends BaseController<Staff, String> {
    @Autowired
    IstaffSv istaffSv;
    @Autowired
    IdepartmentSv idepartment;
    @Autowired
    IpositionSv ipositionSv;

    /**
     * 查询模糊查询所有员工
     */
    @ResponseBody
    @RequestMapping(value = "/selectAllStaff", produces = "text/html;charset=UTF-8")
    public String selectAllStaff(int[] departmentids, int positionid,
                                 int typeid, String number, String name, int groupid) {
        List<Staff> lidytList = istaffSv.selectAll(departmentids, positionid,
            typeid, number, name, groupid);
        return listToJson(lidytList);
    }


    /**
     * 新增员工
     */
    @ResponseBody
    @RequestMapping(value = "/insertStaff", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String insertStaff(Staff sf, MultipartFile file_img)
        throws Exception {
        if (file_img.getSize() > 0) {
            sf.setHeadimage(CommonMethod.saveFile(file_img, "headImg/"));
        }
        sf.setPositiontypeid(1);// 设置人员为在职人员
        return "" + insert(sf);
    }


    /**
     * 获取部门 绑定ztree
     */
    @ResponseBody
    @RequestMapping(value = "/selectDepartment", produces = "text/html;charset=UTF-8")
    public String selectDepartment() {

        return JSON.toJSONString(idepartment.selectAll());
    }


    /**
     * 根据部门id查询部门职务
     */
    @ResponseBody
    @RequestMapping(value = "/selectOpsition", produces = "text/html;charset=UTF-8")
    public String selectOpsition(int[] departmentids) {
        return JSON.toJSONString(ipositionSv.selectBydepartmentIds(departmentids));
    }


    /**
     * 修改员工信息
     */
    @ResponseBody
    @RequestMapping(value = "/updateStaff", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateStaff(Staff sf, MultipartFile file_img)
        throws Exception {
        if (file_img.getSize() > 0) {
            CommonMethod.deleteFile("D:\\Project\\upload\\pic\\"
                + sf.getHeadimage());
            sf.setHeadimage(CommonMethod.saveFile(file_img, "headImg/"));
        }
        String i = update(sf);
        return i;
    }

    public String update(Staff t) {
        return "" + istaffSv.update(t);
    }

    public String insert(Staff t) {
        return "" + istaffSv.insert(t);
    }

    /**
     * 根据staffID查询要修改的数据
     */
    @ResponseBody
    @RequestMapping(value = "/selectByStaffid", produces = "text/html;charset=UTF-8")
    public String selectById(int staffid) {

        return JSON.toJSONString(istaffSv.selectById(staffid));
    }

    @ResponseBody
    @RequestMapping(value = "/deleteStaff", produces = "text/html;charset=UTF-8")
    public String delete(int id) {
        return "" + istaffSv.delete(id);
    }

    @RequestMapping("deleteRecordByStaffid")
    /**班组id改变时删除大于今天的考勤记录**/
    public void deleteRecordByStaffid(int staffid) {
        istaffSv.deleteRecordByStaffid(staffid);
    }

    ;

    @RequestMapping("updateStaffSystem")
    /**修改某个员工制度时改变班次安排大于今天的考勤制度 **/
    public void updateStaffSystem(int staffid, int systemid) {
        istaffSv.updateStaffSystem(staffid, systemid);
    }


    public String selectAll() {

        return null;
    }

}
