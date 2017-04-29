package com.wefine.app.dao;

import com.wefine.app.vo.ChuChaQingJiaTongJi;
import com.wefine.app.vo.ChuQinJiaBanGongXiuTongJiVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KaoQinTongJiDao {
    /**
     * 查询员工出差请假统计的时间
     **/
    List<ChuChaQingJiaTongJi> selectChuChaQingJia(@Param("starDate") String starDate, @Param("endDate") String endDate, @Param("staffids") int[] staffids);

    /**
     * 查询员工出勤、加班、公休统计的时间
     **/
    List<ChuQinJiaBanGongXiuTongJiVo> selectChuQingJiaBanGongXiuTongJi(@Param("starDate") String starDate, @Param("endDate") String endDate, @Param("staffids") int[] staffids);
}
