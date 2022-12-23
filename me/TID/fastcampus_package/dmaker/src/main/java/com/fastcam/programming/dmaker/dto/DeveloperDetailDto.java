package com.fastcam.programming.dmaker.dto;

import com.fastcam.programming.dmaker.code.StatusCode;
import com.fastcam.programming.dmaker.entity.Developer;
import com.fastcam.programming.dmaker.type.DeveloperLevel;
import com.fastcam.programming.dmaker.type.DeveloperSkillTYpe;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDetailDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillTYpe developerSkillTYpe;
    private Integer experienceYears;
    private String memberId;
    private StatusCode statusCode;
    private String name;
    private Integer age;

    public static DeveloperDetailDto fromEntity(Developer developer) {
        return DeveloperDetailDto.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillTYpe(developer.getDeveloperSkillTYpe())
                .experienceYears(developer.getExperienceYears())
                .memberId(developer.getMemberId())
                .statusCode(developer.getStatusCode())
                .name(developer.getName())
                .age(developer.getAge())
                .build();
    }
}
