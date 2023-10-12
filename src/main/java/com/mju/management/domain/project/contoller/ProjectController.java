package com.mju.management.domain.project.contoller;

import com.mju.management.domain.project.service.ProjectService;
import com.mju.management.domain.project.infrastructure.Project;
import com.mju.management.global.model.Result.CommonResult;
import com.mju.management.global.service.ResponseService;
import com.mju.management.domain.project.dto.ProjectRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@CrossOrigin("*")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    ResponseService responseService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    //프로젝트 등록
    @PostMapping()
    public CommonResult registerProject(@RequestBody ProjectRegisterDto projectRegisterDto) {
        projectService.registerProject(projectRegisterDto);
        return responseService.getSuccessfulResult();
    }
    //프로젝트 전체 조회
    @GetMapping()
    public CommonResult getProject() {
        List<Project> project = projectService.getProject();
        return responseService.getListResult(project);
    }
    //프로젝트 수정
    @PutMapping("/{projectIndex}")
    public CommonResult updateProject(@PathVariable Long projectIndex, @RequestBody ProjectRegisterDto projectRegisterDto){
        projectService.updateProject(projectIndex, projectRegisterDto);
        return responseService.getSuccessfulResult();
    }
    //프로젝트 삭제
    @DeleteMapping("/{projectIndex}")
    public CommonResult deleteProject(@PathVariable Long projectIndex){
        projectService.deleteProject(projectIndex);
        return responseService.getSuccessfulResult();
    }
    //프로젝트 완료 표시
    @GetMapping("/{projectIndex}")
    public CommonResult finishCheckList(@PathVariable Long projectIndex){
        projectService.finishProject(projectIndex);
        return responseService.getSuccessfulResult();
    }
}
