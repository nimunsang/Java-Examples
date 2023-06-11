package com.example.apidevelop1.domain.user.service;

import com.example.apidevelop1.IntegrationTest;
import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import utils.Constants;

import java.util.NoSuchElementException;


@IntegrationTest
public class UserWriteServiceTest {

    @Autowired
    private UserWriteService userWriteService;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("중복이름 등록 테스트")
    @Test
    public void testDuplicatedName() {
        String duplicatedName = userRepository.getRandomUser().getName();
        String normalEmail = "ppp@pppp.com";
        UserRegisterCommand command = new UserRegisterCommand(duplicatedName, normalEmail);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> userWriteService.register(command));
    }

    @DisplayName("중복이메일 등록 테스트")
    @Test
    public void testDuplicatedEmail() {
        String normalName = "pppp";
        String duplicatedEmail = userRepository.getRandomUser().getEmail();
        UserRegisterCommand command = new UserRegisterCommand(normalName, duplicatedEmail);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> userWriteService.register(command));
    }

    @DisplayName("이름 길이 작음 테스트")
    @Test
    public void testShortName() {
        String shortName = "p".repeat(Constants.NAME_LENGTH_MIN - 1);
        String normalEmail = "test@test.com";
        UserRegisterCommand command = new UserRegisterCommand(shortName, normalEmail);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> userWriteService.register(command));
    }

    @DisplayName("이름 길이 김 테스트")
    @Test
    public void testLongName() {
        String longName = "p".repeat(Constants.NAME_LENGTH_MAX + 1);
        String normalEmail = "test@test.com";
        UserRegisterCommand command = new UserRegisterCommand(longName, normalEmail);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> userWriteService.register(command));
    }

    @DisplayName("이름 길이 적합함 테스트")
    @Test
    public void testAppropriateName() {
        String normalName = "p".repeat(Constants.NAME_LENGTH_APPROPRIATE);
        String normalEmail = "test@test.com";
        UserRegisterCommand command = new UserRegisterCommand(normalName, normalEmail);
        User user = userWriteService.register(command);

        Assertions.assertNotNull(user);
    }

    @DisplayName("사용자 이름 변경 성공 테스트")
    @Test
    public void testUpdateAppropriateName() {
        String to = "p".repeat(Constants.NAME_LENGTH_APPROPRIATE);
        User randomUser = userRepository.getRandomUser();

        randomUser.changeName(to);

        Assertions.assertEquals(randomUser.getName(), to);
    }

    @DisplayName("사용자 짧은 이름 변경실패 테스트")
    @Test
    public void testUpdateShortName() {
        String shortName = "p".repeat(Constants.NAME_LENGTH_MIN - 1);
        User randomUser = userRepository.getRandomUser();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> randomUser.changeName(shortName));
    }

    @DisplayName("사용자 긴 이름 변경실패 테스트")
    @Test
    public void testUpdateLongName() {
        String longName = "p".repeat(Constants.NAME_LENGTH_MAX + 1);
        User randomUser = userRepository.getRandomUser();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> randomUser.changeName(longName));
    }


    @DisplayName("사용자 이메일 변경 성공 테스트")
    @Test
    public void testUpdateAppropriateEmail() {
        String normalEmail = "test@test.com";
        User randomUser = userRepository.getRandomUser();

        randomUser.changeEmail(normalEmail);

        Assertions.assertEquals(randomUser.getEmail(), normalEmail);
    }

    @DisplayName("사용자 이메일 변경 실패 테스트")
    @Test
    public void testUpdateNotMatchesPatternEmail() {
        String wrongEmail = "test";
        User randomUser = userRepository.getRandomUser();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> randomUser.changeEmail(wrongEmail));
    }

    @DisplayName("사용자 id로 삭제 성공 테스트")
    @Test
    public void testDeleteUserById() {
        User randomUser = userRepository.getRandomUser();
        int removedUserCount = userWriteService.deleteById(randomUser.getId());

        Assertions.assertTrue(removedUserCount > 0);
    }

    @DisplayName("사용자 id로 삭제 실패 테스트")
    @Test
    public void testDeleteNotExistingUserById() {
        Long garbageId = -1L;
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> userWriteService.deleteById(garbageId));
    }
}
