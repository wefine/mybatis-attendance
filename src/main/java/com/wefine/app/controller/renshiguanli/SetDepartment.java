package com.wefine.app.controller.renshiguanli;

import com.alibaba.fastjson.JSON;
import com.wefine.app.core.base.BaseController;
import com.wefine.app.po.Department;
import com.wefine.app.po.StaffPosition;
import com.wefine.app.service.renshiguanli.setdepartment.IdepartmentSv;
import com.wefine.app.service.renshiguanli.setdepartment.IpositionSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/setDeparment")
public class SetDepartment extends BaseController<Department, String> {

    @Autowired
    IdepartmentSv idepartment;
    @Autowired
    IpositionSv ipositionSv;

    @RequestMapping("/main")
    public String selectAll() {
        List<Department> departments = idepartment.selectAll();
        request.setAttribute("departments", departments);
        return "/renshiguanli/jigoushezhi/main";
    }

    /*
     * 修改部门
     */
    @ResponseBody
    @RequestMapping("/update")
    public String update(Department t) {
        return "" + idepartment.update(t);
    }

    /*
     * 新增部门
     */
    @ResponseBody
    @RequestMapping("/insert")
    public String insert(Department t) {
        return "" + idepartment.insert(t);
    }

    @Override
    public String selectById(int id) {

        return null;
    }

    @Override
    public String delete(int id) {
        return "";
    }

    /*
     * 根据属性集合id查询属性明细（查询绑定职务下拉框）
     */
    @ResponseBody
    @RequestMapping(value = "/selectByAttributeGatherId", produces = "text/html;charset=UTF-8")
    public String selectByAttributeGatherId(int attributeGatherId) {
        return JSON.toJSONString(idepartment.selectByAttributeGatherId(attributeGatherId));
    }

    /*
     * 机构职务的操作
     */
    @ResponseBody
    @RequestMapping(value = "/selectOpsition", produces = "text/html;charset=UTF-8")
    public String selectBydepartmentId(int departmentid) {

        return JSON.toJSONString(ipositionSv.selectBydepartmentId(departmentid));
    }

    /*
     * 新增修改职务
     */
    @ResponseBody
    @RequestMapping(value = "/add_editOpsition")
    public String add_editOpsition(StaffPosition t, String add_edit) {
        if (add_edit.equals("add")) {
            return "" + ipositionSv.insert(t);
        } else {
            return "" + ipositionSv.update(t);
        }

    }

    /*
     * 删除职务
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOpsition")
    public String deleteOpsition(int opsitionid) {
        return "" + ipositionSv.delete(opsitionid);
    }
}
