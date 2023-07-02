package com.example.kakaopractice.global.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter // Getter를 넣어줘야 ApiResponse가 제대로 동작한다. (없다면, 406 error: Not Acceptable 발생)
@NoArgsConstructor
public class ApiResponse {

    private String success;

    private Object response;

    @JsonProperty("error") // json응답의 필드명 변경 (apiError -> error)
    private ApiError apiError;

    @Builder
    public ApiResponse(String success, Object response, ApiError apiError) {
        this.success = success;
        this.response = response;
        this.apiError = apiError;
    }

    public static ApiResponse OK() {
        return new ApiResponse();
    }

    public static ApiResponse OK(Object response) {
        return ApiResponse.builder()
                .success("true")
                .response(response)
                .apiError(null)
                .build();
    }

    public static ApiResponse ERROR(String errorMessage, int errorCode) {
        ApiError apiError = new ApiError(errorMessage, errorCode);
        return ApiResponse.builder()
                .success("false")
                .response(null)
                .apiError(apiError)
                .build();
    }
}
