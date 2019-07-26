package com.deer.wms.produce.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.produce.manage.model.MaterialsInfo;
import com.deer.wms.produce.manage.model.MaterialsInfoParams;
import com.deer.wms.produce.manage.service.MaterialsInfoService;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List; 



/**
* Created by  on 2019/07/18.
*/
@Api(description = "xxx接口")
@RestController
@RequestMapping("/materials/infos")
public class MaterialsInfoController {

    @Autowired
    private MaterialsInfoService materialsInfoService;

    @OperateLog(description = "添加xxx", type = "增加")
    @ApiOperation(value = "添加xxx", notes = "添加xxx")
    @PostMapping("/add")
    public Result add(@RequestBody MaterialsInfo materialsInfo, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
		 materialsInfo.setCreateTime(new Date());
		 materialsInfo.setCompanyId(currentUser.getCompanyId());
        materialsInfoService.save(materialsInfo);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "删除xxx", type = "删除")
    @ApiOperation(value = "删除xxx", notes = "删除xxx")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
       materialsInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    
    @OperateLog(description = "修改xxx", type = "更新")
    @ApiOperation(value = "修改xxx", notes = "修改xxx")
    @PostMapping("/update")
    public Result update(@RequestBody MaterialsInfo materialsInfo) {
        materialsInfoService.update(materialsInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MaterialsInfo materialsInfo = materialsInfoService.findById(id);
        return ResultGenerator.genSuccessResult(materialsInfo);
    }


//    @OperateLog(description = "商品信息分页查询new", type = "查询new")
//    @ApiOperation(value = "商品信息列表分页", notes = "商品信息列表分页")
//    @GetMapping("/list/new")
//    public Result productListNew(MtAloneProductParams params, @ApiIgnore @User CurrentUser currentUser) {
//        if (currentUser == null) {
//            return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR, "未登录错误", null);
//        }
//        StringUtil.trimObjectStringProperties(params);
//
//        if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT) {
//            params.setCompanyId(currentUser.getCompanyId());
//        } else {
//            params.setCompanyId(null);
//        }
//
//        PageHelper.startPage(params.getPageNum(), params.getPageSize());
//        List<MtAloneProductVO> list = mtAloneProductService.findListNew(params);
////		List<MtAloneProductVO> listNew = new ArrayList();
//
////		for (int i = 0; i < list.size(); i++) {
////			if (list.get(i).getRemainLength() != 0 || list.get(i).getDeliveryLength() == 0) {
////				listNew.add(list.get(i));
////			}
////		}
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

    @OperateLog(description = "物料信息分页查询", type = "查询")
    @ApiOperation(value = "物料信息列表分页", notes = "物料信息列表分页")
    @GetMapping("/list")
    public Result list(MaterialsInfoParams params, @ApiIgnore @User CurrentUser currentUser) {
        //if(currentUser==null){
        //    return ResultGenerator.genFailResult(CommonCode.SERVICE_ERROR,"未登录错误",null );
        //}
        //StringUtil.trimObjectStringProperties(params);

        params.setCompanyId(0);
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MaterialsInfo> list = materialsInfoService.findList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
