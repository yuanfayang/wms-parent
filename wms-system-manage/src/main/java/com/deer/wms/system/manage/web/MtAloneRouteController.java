package com.deer.wms.system.manage.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.system.manage.model.MtAloneRoute;
import com.deer.wms.system.manage.model.MtAloneRouteCriteria;
import com.deer.wms.system.manage.model.resource.RouteParams;
import com.deer.wms.system.manage.service.MtAloneRouteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by  on 2019/01/31.
*/
@RestController
@RequestMapping("/mt/alone/routes")
public class MtAloneRouteController {

    @Autowired
    private MtAloneRouteService mtAloneRouteService;

    @PostMapping("/add")
    public Result add(@RequestBody MtAloneRoute mtAloneRoute) {
    	mtAloneRoute.setCreateTime(new Date());
    	mtAloneRoute.setUpdateTime(new Date());
        mtAloneRouteService.save(mtAloneRoute);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete( Integer mtAloneRouteId) {
        mtAloneRouteService.deleteById(mtAloneRouteId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MtAloneRoute mtAloneRoute) {
    	mtAloneRoute.setUpdateTime(new Date());
        mtAloneRouteService.update(mtAloneRoute);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneRoute mtAloneRoute = mtAloneRouteService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneRoute);
    }

    @GetMapping("/list")
    public Result list(MtAloneRouteCriteria criteria) {
        PageHelper.startPage(criteria.getPageNum(), criteria.getPageSize());
        List<MtAloneRoute> list = mtAloneRouteService.findList(criteria);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    /**
     * 根据菜单id获取路由列表
     * @param criteria
     * @return
     */
    @GetMapping("/listByResourceId")
    public Result listByResourceId(RouteParams routeParams) {
        PageHelper.startPage(routeParams.getPageNum(), routeParams.getPageSize());
        List<MtAloneRoute> list = mtAloneRouteService.findListByResourceId(routeParams);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    /**
     * 根据父类id获取树形路由
     * @param resource
     * @return
     */
	@GetMapping("/findRouteByParentId/{id}")
	@OperateLog(description = "根据父类id查询菜单列表", type = "查询")
	public Result findRouteByParentId(@PathVariable Integer id) {
		System.out.println("parentId=" + id);
		List<MtAloneRoute> list = mtAloneRouteService.findRouteByParentId(id);
		return ResultGenerator.genSuccessResult(list);
	}

}
