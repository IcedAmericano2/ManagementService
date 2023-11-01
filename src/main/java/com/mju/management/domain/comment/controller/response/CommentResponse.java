package com.mju.management.domain.comment.controller.response;

import com.mju.management.domain.comment.domain.Comment;
import com.mju.management.global.config.jwtInterceptor.JwtContextHolder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class CommentResponse {
    @Schema(description = "댓글 Id")
    private Long id;

    @Schema(description = "작성 시간 (2023.09.16 11:11)")
    private String createdAt;

    @Schema(description = "댓글")
    private String content;

    @Schema(description = "게시글 Id")
    private Long postId;

    @Schema(description = "수정 시간 (2023.09.16 11:11)")
    private String updatedAt;

    @Schema(description = "댓글 작성자")
    private String userName;


    public static String changDateFormat(LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss"));
    }

    public static CommentResponse from(Comment comment){
        return CommentResponse.builder()
                .id(comment.getId())
                .createdAt(changDateFormat(comment.getCreatedAt()))
                .updatedAt(comment.getUpdatedAt() == null ? null : changDateFormat(comment.getUpdatedAt()))
                .content(comment.getContent())
                .postId(comment.getPost().getId())
                .userName(JwtContextHolder.getUsername())
                .build();
    }

    public static List<CommentResponse> fromList(List<Comment> comments){
        List<CommentResponse> commentResponses = new ArrayList<>();
        comments.forEach(comment -> {
            commentResponses.add(CommentResponse.from(comment));
        });
        return commentResponses;
    }

}
