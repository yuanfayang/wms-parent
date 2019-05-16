package com.deer.wms.base.system.web;
import com.deer.wms.base.system.constant.BaseSystemConstant;
import com.deer.wms.base.system.model.ItemType;
import com.deer.wms.base.system.model.ItemTypeCriteria;
import com.deer.wms.base.system.model.ItemTypeParams;
import com.deer.wms.base.system.model.WareInfoCriteria;
import com.deer.wms.base.system.service.ItemTypeService;
import com.deer.wms.intercept.annotation.Authority;
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

import java.util.List;

/**
* Created by  on 2018/06/28.
*/
@RestController
@RequestMapping("/item/types")
@Api(description = "物料类型接口")
public class ItemTypeController {

    @Autowired
    private ItemTypeService itemTypeService;
    @PostMapping("/insert")
    @ApiOperation(value="添加物料类型信息",notes="添加物料类型信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    public Result add(@RequestBody ItemType itemType, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        Integer companyId = currentUser.getCompanyId();
        itemType.setCompanyId(companyId);
        String itemTypeCode="IT"+companyId+RandomNo.createTimeString().substring(7,14);
        itemType.setItemTypeCode(itemTypeCode);
        itemTypeService.save(itemType);
        return ResultGenerator.genSuccessResult();
    }

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/delete")
    //@ApiOperation(value="删除物料类型信息",notes="删除物料类型信息")
    //public Result delete( String itemTypeCode,@ApiIgnore @User CurrentUser currentUser) {
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    Integer companyId ;
    //    ItemTypeCriteria criteria = new ItemTypeCriteria();
    //    criteria.setItemTypeCode(itemTypeCode);
    //    if(currentUser.getCompanyType() != -1){
    //        companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //
    //    itemTypeService.deleteByCodeAndCom(criteria);
    //    return ResultGenerator.genSuccessResult();
    //}

    /**
     * 如果有子类型，不允许删除
     * @param itemTypeId
     * @param currentUser
     * @return
     */
    @Authority
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
            , @ApiImplicitParam(name = "colorId", value = "类型id", paramType="path", dataType="Integer", required = true)
    })
    @DeleteMapping("/delete/{itemTypeId}")
    @ApiOperation(value="删除物料类型信息",notes="删除物料类型信息")
    @OperateLog(description = "删除物料类型", type = "删除")
    public Result delete( @PathVariable Integer itemTypeId, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }

        ItemTypeParams params = new ItemTypeParams();
        params.setItemTypeId(itemTypeId);
        params.setCompanyId(currentUser.getCompanyId());

        Integer countChildren = itemTypeService.countChildren(params);//统计子节点数
        Integer countRelProducts = itemTypeService.countRelProducts(params);//统计关联产品数

        if(countRelProducts!=0){
            return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"该类型下有关联的货物，无法删除！",null);
        }
        if(countChildren!=0){
            return ResultGenerator.genSuccessResult(CommonCode.HAVE_CHILDREN_RECORD,"该类型下有子类型，无法删除！",null);
        }

        itemTypeService.deleteByIdAndCom(params);
        return ResultGenerator.genSuccessResult();
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @PostMapping("/update")
    @ApiOperation(value="更新物料类型信息",notes="更新物料类型信息")
    public Result update(@RequestBody ItemType itemType, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser == null){
            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
        }
        Integer companyId = currentUser.getCompanyId();
        itemType.setCompanyId(companyId);
        itemTypeService.update(itemType);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    @ApiOperation(value="单个物料类型查询",notes="单个物料类型查询")
    public Result detail( Integer id) {
        ItemType itemType = itemTypeService.findById(id);
        return ResultGenerator.genSuccessResult(itemType);
    }

    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    //})
    //@GetMapping("/list")
    //@ApiOperation(value="物料类型查询列表",notes="物料类型查询列表")
    //public Result list(ItemTypeCriteria criteria, @ApiIgnore @User CurrentUser currentUser) {
    //    if(currentUser == null){
    //        return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录！",null);
    //    }
    //    if(currentUser.getCompanyType() != -1){
    //        Integer companyId    = currentUser.getCompanyId();
    //        criteria.setCompanyId(companyId);
    //    }
    //    PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
    //    List<ItemType> list = itemTypeService.findList(criteria);
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/list")
    @ApiOperation(value="物料类型查询列表",notes="物料类型查询列表")
    public Result listNew(ItemTypeParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<ItemType> list = itemTypeService.findListNew(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @OperateLog(description = "子类型查询列表", type = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/childrenList")
    @ApiOperation(value="子类型查询列表",notes="子类型查询列表")
    public Result childrenList(ItemTypeParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<ItemType> list = itemTypeService.findChildrenList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @OperateLog(description = "父类型查询", type = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType="header", dataType="String", required = true)
    })
    @GetMapping("/parent")
    @ApiOperation(value="父类型查询",notes="父类型查询")
    public Result parent(ItemTypeParams params, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }

        StringUtil.trimObjectStringProperties(params);
        params.setCompanyId(currentUser.getCompanyId());

        ItemType parent = itemTypeService.findParent(params);
        return ResultGenerator.genSuccessResult(parent);
    }
}
