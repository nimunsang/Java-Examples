package com.example.apidevelop1.factory;

import com.example.apidevelop1.domain.user.dto.UserDto;
import com.example.apidevelop1.domain.user.entity.User;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;
import org.jeasy.random.randomizers.text.StringRandomizer;
import org.jeasy.random.randomizers.time.LocalDateRandomizer;


import static org.jeasy.random.FieldPredicates.named;

public class UserFixtureFactory {

    public static User create() {
        var parameter = new EasyRandomParameters()
                .excludeField(named("id"))
                .stringLengthRange(2, 20)
                .randomize(Long.class, new LongRangeRandomizer(1L, 100L));
        return new EasyRandom(parameter).nextObject(User.class);
    }

    public static UserDto createDto() {
        var parameter = new EasyRandomParameters()
                .stringLengthRange(1, 10)
                .randomize(Long.class, new LongRangeRandomizer(1L, 100L));
        return new UserDto(
                new LongRangeRandomizer(1L, 100L).getRandomValue(),
                new StringRandomizer(10).getRandomValue(),
                new StringRandomizer(10).getRandomValue(),
                new LocalDateRandomizer().getRandomValue()
        );
    }
}
