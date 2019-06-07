package com.deer.wms.workflow.web;

import com.alibaba.fastjson.JSON;
import com.deer.wms.workflow.model.Msg;
import com.deer.wms.workflow.model.ProcessDefinitionVO;
import com.deer.wms.workflow.service.ProcessInstanceStartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ProcessInstanceController
 * 流程实例管理
 *
 * @author luxin.yan
 * @date 2019/2/17
 **/
@RestController
@RequestMapping("/workflow/processInstance")
@Api(tags = "流程实例管理", value = "流程实例管理")
public class ProcessInstanceController {
    private static final Logger logger = LoggerFactory.getLogger(ProcessInstanceController.class);
    @Autowired
    @Qualifier(value = "processInstanceStartServiceImpl")
    private ProcessInstanceStartService processInstanceStartService;
    @Resource
    private RepositoryService repositoryService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询流程定义模板", notes = "提交查询条目数进行分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "pageSize", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "name", paramType = "query", dataType = "String", required = false, value = "流程名称")
    })
    public Msg listProcessDef(@RequestParam int currentPage, @RequestParam int pageSize) {
        List<ProcessDefinition> processDefinitionList = processInstanceStartService.listProcessDefinition(currentPage * pageSize, pageSize);
        List<ProcessDefinitionVO> processDefinitionVOList = new ArrayList<>();
        processDefinitionList.forEach(processDefinition -> {
            ProcessDefinitionVO processDefinitionVO = new ProcessDefinitionVO();
            processDefinitionVO.setId(processDefinition.getId());
            processDefinitionVO.setName(processDefinition.getName());
            processDefinitionVO.setKey(processDefinition.getKey());
            processDefinitionVO.setVersion(processDefinition.getVersion());
            processDefinitionVOList.add(processDefinitionVO);
        });
        PageHelper.startPage(currentPage, pageSize);
        Msg<List<ProcessDefinition>> msg = new Msg("sucess", true).setData(processDefinitionVOList);
        msg.setCurrentPage(currentPage);
        msg.setPageSize(pageSize);
        return msg;
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    @ApiOperation(value = "流程启动", notes = "流程启动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "processKey", paramType = "query", dataType = "String", value = "流程key"),
            @ApiImplicitParam(name = "formJson", paramType = "query", dataType = "String", value = "流程实例ID"),
    })
    public Msg startProcessInstance(@RequestParam String processKey, @RequestParam String formJson) {
        ProcessDefinition processDefinition = null;
        if (StringUtils.isNotBlank(processKey)) {
            processDefinition = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionKey(processKey).latestVersion().singleResult();
        }

        if (processDefinition == null) {
            logger.debug("启动流程失败：当前流程定义不存在， processKey={}", JSON.toJSONString(processKey));
            return new Msg<>("当前流程定义[" + processKey + "]不存在", false);
        }
        ProcessInstance processInstance = processInstanceStartService.startProcessInstance(processDefinition.getId(), "", formJson);
        if (processInstance!=null) {
            Msg msg = new Msg("流程启动成功", true).setData(processInstance.getProcessInstanceId());
            return msg;
        }
        return new Msg("流程启动失败", false);
    }

    @RequestMapping(value = "/diagram", method = RequestMethod.GET)
    @ApiOperation(value = "流程实例图", notes = "任务ID和流程ID必须传其一")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "processInstanceId", paramType = "query", dataType = "String", required = true, value = "流程实例ID"),
            @ApiImplicitParam(name = "autoLayout", paramType = "query", dataType = "Boolean", value = "流程实例ID")
    })
    public void genProcessDiagram(String processInstanceId, boolean autoLayout, HttpServletResponse httpServletResponse) throws IOException {
        InputStream in = processInstanceStartService.genProcessDiagram(processInstanceId, autoLayout);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("image/png; charset=utf-8");
        OutputStream out = null;
        try {
            out = httpServletResponse.getOutputStream();
            IOUtils.copy(in, out);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
