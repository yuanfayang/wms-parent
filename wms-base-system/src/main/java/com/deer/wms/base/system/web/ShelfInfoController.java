package com.deer.wms.base.system.web;
import com.deer.wms.base.system.constant.BaseSystemConstant;
import com.deer.wms.base.system.model.*;
import com.deer.wms.base.system.service.AreaInfoService;
import com.deer.wms.base.system.service.CellInfoService;
import com.deer.wms.base.system.service.ShelfInfoService;
import com.deer.wms.base.system.service.WareInfoService;
import com.deer.wms.intercept.annotation.Authority;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.DateUtils;
import com.deer.wms.project.seed.util.RandomNo;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
* Created by  on 2018/06/20.
*/
@Api(description = "货架管理接口")
@RestController
@RequestMapping("/shelf/infos")
public class ShelfInfoController {

    @Autowired
    private ShelfInfoService shelfInfoService;
    @Autowired
    private CellInfoService cellInfoService;
    @Autowired
    private AreaInfoService   areaInfoService;
    @Autowired
    private WareInfoService  wareInfoService;

    @PostMapping("/insert")
    @ApiOperation(value="添加货架信息",notes="添加货架信息")
    @Transactional
    public Result add(@RequestBody ShelfInfo shelfInfo, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        Integer companyId = currentUser.getCompanyId();

        AreaInfo areaInfo = areaInfoService.findBy("areaCode",shelfInfo.getAreaCode());
        WareInfo wareInfo = wareInfoService.findBy("wareCode",areaInfo.getWareCode());
        String  nowDate = DateUtils.getNowDateTimeString();
        shelfInfo.setAddTime(nowDate);
        shelfInfo.setCompanyId(companyId);
        String shelfCode= "HJ" + companyId  +"-"+ wareInfo.getWareId()
                +"-"+ areaInfo.getAreaId()   +"-"+  RandomNo.createTimeString().substring(8,14);
        shelfInfo.setShelfCode(shelfCode);
        shelfInfoService.save(shelfInfo);
        ShelfInfo shelfInfoSaved = shelfInfoService.findBy("shelfCode",shelfInfo.getShelfCode());
        Integer shelfRow=shelfInfo.getShelfRow();
        Integer shelfColumn=shelfInfo.getShelfColumn();
        Float shelfL = shelfInfo.getShelfL();
        Float shelfW = shelfInfo.getShelfW();
        Float shelfH = shelfInfo.getShelfH();

        Float cellL = shelfL/shelfRow;
        Float cellW = shelfW;
        Float cellH = shelfH/shelfColumn;

        List<CellInfo> shelfList=new ArrayList<CellInfo>();
        for(int i=1;i<=shelfRow;i++){
            for (int j=1;j<=shelfColumn;j++){

                String cellCode= "HW" + "-"+companyId  +"-"+ wareInfo.getWareId() +"-"+  areaInfo.getAreaId()  +"-"+shelfInfoSaved.getShelfId() + "-"+ i +"-"+   j;
                String cellName=areaInfo.getAreaName()+"-"+shelfInfo.getShelfName()+ "-"+i +"-"+   j;
                
                CellInfo cellInfo=new CellInfo();
                cellInfo.setCompanyId(companyId);
                cellInfo.setCellCode(cellCode);
                cellInfo.setMemo(cellName);
                cellInfo.setCellName(cellName);
                cellInfo.setCellAlias(cellName);    //别名跟名称默认相同，可以修改， @wb 2019-05-20

                cellInfo.setShelfCode(shelfInfo.getShelfCode());
                cellInfo.setsColumn(j);
                cellInfo.setsRow(i);
                cellInfo.setCellL(cellL);
                cellInfo.setCellW(cellW);
                cellInfo.setCellH(cellH);
                //默认无货
                cellInfo.setState(0);
                cellInfo.setAddTime(nowDate);
                shelfList.add(cellInfo);
            }
        }
         cellInfoService.save(shelfList);
//        cellInfoService.setOrder(shelfInfo);


        return ResultGenerator.genSuccessResult();
    }

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/delete")
    //@ApiOperation(value="删除货架信息",notes="删除货架信息")
    //public Result delete( String shelfCode,@ApiIgnore @User CurrentUser currentUser) {
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    Integer companyId ;
    //    ShelfInfoCriteria criteria=new ShelfInfoCriteria();
    //    criteria.setShelfCode(shelfCode);
    //    if(currentUser.getCompanyType() != -1){
    //        companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //    shelfInfoService.deleteByCodeAndCom(criteria);
    //    return ResultGenerator.genSuccessResult();
    //}

    /**
     * 按照id删除
     * 原则：只能删除货位没有货的货架，如果货位有货，则不能删除，删除无货的货架需要将其下货位一并删除
     * @param shelfId
     * @param currentUser
     * @return
     */
    @Authority
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
            , @ApiImplicitParam(name = "shelfId", value = "货架id", paramType="path", dataType="Integer", required = true)
    })
    @DeleteMapping("/delete/{shelfId}")
    @ApiOperation(value="删除货架信息",notes="删除货架信息")
    @OperateLog(description = "删除货架", type = "删除")
    public Result delete(@PathVariable Integer shelfId, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        ShelfInfoParams params = new ShelfInfoParams();
        params.setShelfId(shelfId);
        params.setCompanyId(currentUser.getCompanyId());

        Integer countNoEmptyCells = shelfInfoService.countNoEmptyCells(params);
        if(countNoEmptyCells != 0){
            return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"该货架下有关联的货物，无法删除！",null);
        }

        shelfInfoService.deleteByIdAndComNew(params);
        cellInfoService.deleteByShelfId(params);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    @ApiOperation(value="更新货架信息",notes="更新货架信息")
    public Result update(@RequestBody ShelfInfo shelfInfo,@ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        shelfInfoService.update(shelfInfo);
//        cellInfoService.setOrder(shelfInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    @ApiOperation(value="单个货架查询",notes="单个货架查询")
    public Result detail( Integer id) {
        ShelfInfo shelfInfo = shelfInfoService.findById(id);
        return ResultGenerator.genSuccessResult(shelfInfo);
    }



    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/list")
    //@ApiOperation(value="货架查询列表",notes="货架查询列表")
    //public Result list(ShelfInfoCriteria criteria, @ApiIgnore @User CurrentUser currentUser) {
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    if(currentUser.getCompanyType() != -1){
    //        Integer companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<ShelfInfoDto> list = shelfInfoService.findList(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}


    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/list")
    @ApiOperation(value="货架查询列表",notes="货架查询列表")
    public Result listNew(ShelfInfoParams params, @ApiIgnore @User CurrentUser currentUser) {

        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<ShelfInfoDto> list = shelfInfoService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
