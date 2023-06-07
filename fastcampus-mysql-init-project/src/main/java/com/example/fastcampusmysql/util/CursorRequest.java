package com.example.fastcampusmysql.util;

public record CursorRequest(Long key, int size) {
    // 1. 인덱스가 존재해야 하고
    // 2. 중복 가능성이 없어야 함

    public static final Long NONE_KEY = -1L;

    public Boolean hasKey() {
        return key != null;
    }

    public CursorRequest next(Long key) {
        return new CursorRequest(key, size);
    }

}
