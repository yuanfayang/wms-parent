package com.deer.wms.workflow.web;

import com.deer.wms.workflow.model.Msg;
import com.deer.wms.workflow.model.TaskForm;
import com.deer.wms.workflow.model.TaskImplVo;
import com.deer.wms.workflow.service.TaskInstanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.ManagementService;
import org.flowable.engine.TaskService;
import org.flowable.form.api.FormInfo;
import org.flowable.form.api.FormRepositoryService;
import org.flowable.task.api.Task;
import org.flowable.ui.modeler.serviceapi.ModelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * TaskInstanceController
 *
 * @author luxin.yan
 * @date 2019/1/9
 **/
@RestController
@RequestMapping("/workflow/task_ins")
@Api(tags = "流程任务实例管理", value = "流程任务实例管理")
public class TaskInstanceController {

    @Resource
    private TaskInstanceService taskInstanceServiceImpl;
    @Resource
    private ModelService modelServiceImpl;
    @Resource
    private ManagementService managementService;
    @Resource
    private TaskService taskService;
    @Resource
    private FormRepositoryService formRepositoryService;

    @RequestMapping(value = "/l/listCandidateTask", method = RequestMethod.POST)
    @ApiOperation(value = "获取需要接收的任务", notes = "获取需要接收的任务")
    public Msg listCandidateTask(@RequestBody TaskForm taskForm) {

        PageHelper.startPage(taskForm.getCurrentPage(), taskForm.getPageSize());
        List<Task> taskList = taskInstanceServiceImpl.listCandidateTask(taskForm);
        List<TaskImplVo> taskImplVos = changeTaskToTaskVo(taskList);
        PageInfo<Task> pageInfo = new PageInfo<>(taskList);
        Msg<List<TaskImplVo>> msg = new Msg("sucess", true).setData(taskImplVos);

        msg.setPrototype(taskForm.getCurrentPage(), taskForm.getPageSize(), pageInfo.getTotal());
        return msg;
    }


    @RequestMapping(value = "/l/listAssigneeTasks", method = RequestMethod.POST)
    @ApiOperation(value = "查询用户可受理的任务", notes = "查询用户可受理的任务")
    public Msg listAssigneeTasks(@RequestBody TaskForm taskForm) {

        PageHelper.startPage(taskForm.getCurrentPage(), taskForm.getPageSize());
        List<Task> taskList = taskInstanceServiceImpl.listAssigneeTasks(taskForm);
        List<TaskImplVo> taskImplVos = changeTaskToTaskVo(taskList);
        PageInfo<Task> pageInfo = new PageInfo<>(taskList);
        Msg<List<TaskImplVo>> msg = new Msg("sucess", true).setData(taskImplVos);
        msg.setPrototype(taskForm.getCurrentPage(), taskForm.getPageSize(), pageInfo.getTotal());
        return msg;
    }

    private List<TaskImplVo> changeTaskToTaskVo(final List<Task> taskList) {
        List<TaskImplVo> taskImplVos = new ArrayList<>(taskList.size());
        taskList.forEach(task -> {
            TaskImplVo taskImplVo = new TaskImplVo();
            taskImplVo.setTaskId(task.getId());
            taskImplVo.setTaskName(task.getName());
            taskImplVo.setFormKey(task.getFormKey());
            taskImplVo.setProcessInstanceId(task.getProcessInstanceId());
            taskImplVo.setProcessId(task.getProcessDefinitionId());
            taskImplVos.add(taskImplVo);
        });
        return taskImplVos;
    }


    @RequestMapping(value = "/u/claim", method = RequestMethod.GET)
    @ApiOperation(value = "领取任务", notes = "领取任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", paramType = "query", dataType = "String", required = true, value = "任务ID"),
            @ApiImplicitParam(name = "userId", paramType = "query", dataType = "String", required = true, value = "用户ID")
    })
    public Msg claimTask(String taskId, String userId) {
        taskInstanceServiceImpl.claimTask(taskId, userId);
        return new Msg("sucess", true);
    }

    @RequestMapping(value = "/u/delegate", method = RequestMethod.GET)
    @ApiOperation(value = "转办任务", notes = "转办任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", paramType = "query", dataType = "String", required = true, value = "任务ID"),
            @ApiImplicitParam(name = "userId", paramType = "query", dataType = "String", required = true, value = "转办用户ID")
    })
    public Msg delegateTask(String taskId, String userId) {
        taskInstanceServiceImpl.delegateTask(taskId, userId);
        return new Msg("sucess", true);
    }

    @RequestMapping(value = "/u/rollback", method = RequestMethod.GET)
    @ApiOperation(value = "流程回退", notes = "默认回退到上一级流程节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", paramType = "query", dataType = "String", required = true, value = "任务ID")
    })
    public Msg rollback(String taskId) {
        taskInstanceServiceImpl.rollback(taskId);
        return new Msg("回退成功", true);
    }


    @RequestMapping(value = "/u/subtractUser", method = RequestMethod.GET)
    @ApiOperation(value = "减签", notes = "删除任务受理人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", paramType = "query", dataType = "String", required = true, value = "任务ID"),
            @ApiImplicitParam(name = "userIds", paramType = "query", dataType = "String", required = true, value = "减签用户列表")
    })
    public Msg subtractUser(String taskId, String userIds) {
        List<String> userList = Arrays.asList(userIds.split(","));
        taskInstanceServiceImpl.subtractUser(taskId, userList);
        return new Msg("减签成功", true);
    }

    @RequestMapping(value = "/u/countersign", method = RequestMethod.GET)
    @ApiOperation(value = "加签", notes = "给任务添加执行人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", paramType = "query", dataType = "String", required = true, value = "任务ID"),
            @ApiImplicitParam(name = "userIds", paramType = "query", dataType = "String", required = true, value = "加签用户列表逗号分隔")
    })
    public Msg countersign(String taskId, String userIds) {
        List<String> userList = Arrays.asList(userIds.split(","));
        taskInstanceServiceImpl.countersign(taskId, userList);
        return new Msg("任务加签成功", true);
    }

    @RequestMapping(value = "/u/dealWith", method = RequestMethod.POST)
    @ApiOperation(value = "流程启动", notes = "根据模板id查询模板信息并返回json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", paramType = "query", dataType = "String", required = true, value = "任务ID"),
            @ApiImplicitParam(name = "formKey", paramType = "query", dataType = "String", required = true, value = "表单KEY"),
            @ApiImplicitParam(name = "comment", paramType = "query", dataType = "String", required = true, value = "处理意见"),
            @ApiImplicitParam(name = "formVariables", paramType = "query", dataType = "String", required = true, value = "表单内容")
    })
    public Msg dealWith(@RequestParam String taskId, @RequestParam String formKey, @RequestParam String comment, @RequestBody Map<String, Object> formVariables) throws IOException {
        String formDefinedId = "";
        if (StringUtils.isNotBlank(formKey)) {
            FormInfo formInfo = formRepositoryService.getFormModelByKey(formKey);
            if (formInfo != null) {
                formDefinedId = formInfo.getId();
            }
        }
        taskInstanceServiceImpl.dealWith(taskId, formDefinedId, "", comment, formVariables);
        return new Msg("任务操作成功", true);
    }

    @RequestMapping(value = "/getTaskFormModel", method = RequestMethod.GET)
    @ApiOperation(value = "获取单个任务表单内容", notes = "获取单个任务表单内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", paramType = "query", dataType = "String", required = true, value = "任务ID"),
    })
    public Msg getTaskFormModel(String taskId) {
        FormInfo formInfo = taskInstanceServiceImpl.getTaskFormModel(taskId);
        return new Msg("获取单个任务表单内容", true).setData(formInfo);
    }

    @RequestMapping(value = "/listFormInstanceByInstandId", method = RequestMethod.GET)
    @ApiOperation(value = "获取一个流程实例的表单列表", notes = "获取一个流程实例的表单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "instandId", paramType = "query", dataType = "String", required = true, value = "流程实例ID"),
    })
    public Msg listTaskFormByInstandId(String instandId) {
        List<FormInfo> formInfoList = taskInstanceServiceImpl.listTaskFormModelByInstanceId(instandId);
        return new Msg("获取表单列表", true).setData(formInfoList);
    }
}
