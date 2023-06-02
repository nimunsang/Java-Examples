package com.example.fastcampusmysql.util;

import com.example.fastcampusmysql.domain.member.entity.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class MemberFixtureFactory {
    static public Member create() {
        var param = new EasyRandomParameters();
        return new EasyRandom(param).nextObject(Member.class);
    }

    static public Member create(Long seed) {
        var param = new EasyRandomParameters().seed(seed);
        return new EasyRandom(param).nextObject(Member.class);
        // 아래와 같은 방식으로 계속 객체를 생성하면, 매우 번거로울 것이다.
        // 그러므로, EasyRandom을 사용해보자.
    }
}
