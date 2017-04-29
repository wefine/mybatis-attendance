package com.wefine.app.service.paibanguangli.paiban;

import com.wefine.app.core.base.BaseService;
import com.wefine.app.po.StaffClassesRecord;
import com.wefine.app.vo.GengGaiPaiPanXinXi;
import com.wefine.app.vo.YuanGongFenBanJiLu;
import com.wefine.app.vo.paibanchaxunVo;

import java.util.List;

public interface IstaffClassesRecordSv extends BaseService<StaffClassesRecord, String> {
    List<paibanchaxunVo> selectClassGroup();

    /**
     * 查询班组员工分班记录
     **/
    List<YuanGongFenBanJiLu> selectGroupRecord(int goupid, String bginDate, String endDate);

    /**
     * 更改班组排班信息
     **/
    public int updatePaiBanXinXi(List<GengGaiPaiPanXinXi> listInsert, int[] deleteIds, List<GengGaiPaiPanXinXi> listUpdate, int groupid);


}
