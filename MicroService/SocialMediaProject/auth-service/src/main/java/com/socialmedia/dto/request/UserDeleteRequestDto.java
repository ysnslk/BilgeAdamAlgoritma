package com.socialmedia.dto.request;

import com.socialmedia.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDeleteRequestDto {
    private Long authId;
    private EStatus eStatus;
}
