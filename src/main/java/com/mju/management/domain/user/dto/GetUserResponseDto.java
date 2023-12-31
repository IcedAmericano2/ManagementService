package com.mju.management.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetUserResponseDto {
    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private boolean isApproved;
}
