package com.deer.wms.base.system.web;
import com.deer.wms.base.system.constant.BaseSystemConstant;
import com.deer.wms.base.system.model.*;
import com.deer.wms.base.system.service.AreaInfoService;
import com.deer.wms.base.system.service.CellInfoService;
import com.deer.wms.base.system.service.ShelfInfoService;
import com.deer.wms.base.system.service.WareInfoService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.RandomNo;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by  on 2018/06/20.
*/
@Api(description = "货位管理接口")
@RestController
@RequestMapping("/cell/infos")
public class CellInfoController {
    @Autowired
    private CellInfoService cellInfoService;
    @Autowired
    private AreaInfoService areaInfoService;
    @Autowired
    private WareInfoService wareInfoService;
    @Autowired
    private ShelfInfoService shelfInfoService;


    @OperateLog(description = "添加货位信息", type = "增加")
    @PostMapping("/insert")
    @ApiOperation(value="添加货位信息",notes="添加货位信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    public Result add(@RequestBody CellInfo cellInfo, @ApiIgnore @User CurrentUser currentUser ) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        Integer companyId = currentUser.getCompanyId();
        ShelfInfo  shelfInfo=shelfInfoService.findBy("wareCode",cellInfo.getShelfCode());
        AreaInfo areaInfo = areaInfoService.findBy("areaCode",shelfInfo.getAreaCode());
        WareInfo wareInfo = wareInfoService.findBy("wareCode",areaInfo.getWareCode());
        String cellCode= "HW" +"-"+ companyId  + "-"+ wareInfo.getWareId() + "-"+ areaInfo.getAreaId()+"-"+shelfInfo.getShelfId()  + "-"+ cellInfo.getsRow() + "-"+ cellInfo.getsColumn() +  RandomNo.createTimeString().substring(7,14);
        String cellName=areaInfo.getAreaName()+"-"+shelfInfo.getShelfName()+ "-"+ cellInfo.getsRow() + "-"+ cellInfo.getsColumn();
        cellInfo.setMemo(cellName);
        cellInfo.setCompanyId(companyId);
        cellInfo.setCellCode(cellCode);
        //默认无货
        cellInfo.setState(0);
        cellInfoService.save(cellInfo);
        return ResultGenerator.genSuccessResult();
    }

    @OperateLog(description = "删除货位信息", type = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/delete")
    @ApiOperation(value="删除货位信息",notes="删除货位信息")
    public Result delete( String  cellCode,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        CellInfoCriteria criteria = new CellInfoCriteria();
        criteria.setCellCode(cellCode);
        criteria.setCompanyId(currentUser.getCompanyId());

        cellInfoService.deleteByCodeAndCom(criteria);
        return ResultGenerator.genSuccessResult();
    }
    @OperateLog(description = "更新货位信息", type = "更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/update")
    @ApiOperation(value="更新货位信息",notes="更新货位信息")
    public Result update(@RequestBody CellInfo cellInfo, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        cellInfoService.update(cellInfo);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @OperateLog(description = "根据货位ID查询货位信息", type = "查询")
    @GetMapping("/detail")
    @ApiOperation(value="单个货位查询",notes="单个货位查询")
    public Result detail( Integer id) {
        CellInfo cellInfo = cellInfoService.findById(id);
        return ResultGenerator.genSuccessResult(cellInfo);
    }

    //@ApiImplicitParams({
    //    @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@OperateLog(description = "货位查询列表", type = "查询")
    //@GetMapping("/list")
    //@ApiOperation(value="货位查询列表",notes="货位查询列表")
    //public Result list(CellInfoCriteria criteria) {
    //
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<CellInfoDto> list = cellInfoService.findList(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @OperateLog(description = "货位查询列表", type = "查询")
    @GetMapping("/list")
    @ApiOperation(value="货位查询列表",notes="货位查询列表")
    public Result listNew(CellInfoParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<CellInfoDto> list = cellInfoService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/listRowColum")
    @ApiOperation(value="货位行列切块列表",notes="货位行列切块列表")
    @OperateLog(description = "货位行列切块列表", type = "查询")
    public Result list(CellInfoCriteriaRowColumn criteria, @ApiIgnore @User CurrentUser currentUser) {
    	
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(criteria);

        if (currentUser.getCompanyType() != BaseSystemConstant.COMPANY_TYPE_MT){
        	criteria.setCompanyId(currentUser.getCompanyId());
        }else{
        	criteria.setCompanyId(null);
        }

        criteria.setBeginRow((criteria.getRowNum()-1)*criteria.getRowSize()+1);
        criteria.setEndRow((criteria.getRowNum()-1)*criteria.getRowSize()+criteria.getRowSize());
        criteria.setBeginColumn((criteria.getColumnNum()-1)*criteria.getColumnSize()+1);
        criteria.setEndColumn((criteria.getColumnNum()-1)*criteria.getColumnSize()+criteria.getColumnSize());

        ShelfInfo shelfInfo=shelfInfoService.findBy("shelfCode", criteria.getShelfCode());
        int shelfRowNum=shelfInfo.getShelfRow();
        int shelfColumnNum=shelfInfo.getShelfRow();
        List<CellInfoDto> listTem = cellInfoService.findListByRowColumn(criteria);

        for(int i=0;i<listTem.size();i++) {
        	if(listTem.get(i).getState()!=null && (3==listTem.get(i).getState()||2==listTem.get(i).getState())) {
        		continue;
        	}
        	if(listTem.get(i).getRollNum()!=0) {
        		listTem.get(i).setState(1);
        	}else {
        		listTem.get(i).setState(0);
        	}
        }

        int firstRow=listTem.get(0).getsRow();
        int lastRow=listTem.get(listTem.size()-1).getsRow();
        List<List<CellInfoDto>> listRowColumn = new ArrayList<List<CellInfoDto>>();
        for(int i=firstRow;i<lastRow+1;i++){
            List<CellInfoDto> ListRow=new ArrayList<>();
            for(int j=0;j<listTem.size();j++) {
                if(listTem.get(j).getsRow()==i){
                    ListRow.add(listTem.get(j));
                }
            }
            listRowColumn.add(ListRow);
        }
        Map map = new HashMap();
        map.put("shelfRowNum", shelfRowNum);
        map.put("shelfColumnNum", shelfColumnNum);
        map.put("listRowColumn", listRowColumn);

        return ResultGenerator.genSuccessResult(map);
    }

}
