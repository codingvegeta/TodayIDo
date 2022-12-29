package com.example.chapter7.user;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;

public class UserRegisterMockTest {
    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker = mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true);

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }

    @DisplayName("회원 가입시 암호 검사 수행함")
    @Test
    void checkPassword() {
        userRegister.register("id", "pw", "email");

        BDDMockito.then(mockPasswordChecker).should().checkPasswordWeak(BDDMockito.anyString());
        // 임의의 String 타입 인자를 이용해서 메서드의 호출 여부를 확인한다.
    }


    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail() {

        userRegister.register("id", "pw", "email@email.com");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        then(mockEmailNotifier).should().sendRegisterEmail(captor.capture());
        System.out.println(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@email.com", realEmail);
    }
}
