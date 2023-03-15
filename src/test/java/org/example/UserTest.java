package org.example;

import org.example.password.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("패스워드를 초기화 한다.")
    @Test
    void passwordTest() {
        //given
        User user = new User();

        //when
        user.initPassword(() -> "abcedfgh");

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        //given
        User user = new User();

        //whenㅋ
        //user.initPassword(new WrongFixedPasswordGenerator());  PasswordGenerator가 FuntionalInterface 이기 때문에 람다식으로도 가능
        user.initPassword(() -> "ab");

        //then
        assertThat(user.getPassword()).isNull();
    }

}