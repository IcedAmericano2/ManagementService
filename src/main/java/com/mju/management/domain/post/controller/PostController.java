package com.mju.management.domain.post.controller;

import com.mju.management.domain.post.model.dto.request.CreatePostRequestDto;
import com.mju.management.domain.post.model.dto.request.DeletePostRequestDto;
import com.mju.management.domain.post.model.dto.request.RetrieveDetailPostRequestDto;
import com.mju.management.domain.post.model.dto.request.UpdatePostRequestDto;
import com.mju.management.global.model.Result.CommonResult;
import com.mju.management.domain.post.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "[기획 /제작/ 편집] 게시글 작성, 수정, 삭제, 상세 조회 API")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PostController {

    private final PostServiceImpl postServiceImpl;

    @Operation(summary = "기획/제작/편집 게시글 작성 API")
    @PostMapping
    public CommonResult createPost(/* @AuthenticationPrincipal User user, */ @Valid @RequestBody CreatePostRequestDto createPostDto){
        return postServiceImpl.createPost(/* user, */ createPostDto.toServiceRequest());
    }

    @Operation(summary = "기획/제작/편집 게시글 상세 조회 API")
    @GetMapping
    public CommonResult retrieveDetailPost(/* @AuthenticationPrincipal User user */ @Valid RetrieveDetailPostRequestDto retrieveDetailPostRequestDto  ){
        System.out.println("sdfslakfjklafsjlkjflad" + retrieveDetailPostRequestDto);

        return postServiceImpl.retrieveDetailPost(/* user, */ retrieveDetailPostRequestDto.toServiceRequest());
    }

    @Operation(summary = "기획/제작/편집 게시글 수정 API")
    @PutMapping
    public CommonResult updatePost(/* @AuthenticationPrincipal User user */ @Valid @RequestBody UpdatePostRequestDto updatePostRequestDto){
        return postServiceImpl.updatePost(/* user, */ updatePostRequestDto.toServiceRequest());
    }

    @Operation(summary = "기획/제작/편집 게시글 삭제 API")
    @DeleteMapping
    public CommonResult deletePost(/* @AuthenticationPrincipal User user */ @Valid @RequestBody DeletePostRequestDto deletePostRequestDto){
        return postServiceImpl.deletePost(/* user, */ deletePostRequestDto.toServiceRequest());
    }

}
