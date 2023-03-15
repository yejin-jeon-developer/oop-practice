package org.example.password;

import lombok.Getter;

@Getter
public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        // 내부에서 생성할 경우 이 부분을 컨트롤 할 수 없어 테스트 만들기 힘듬 (성공하기도 하고 실패하기도 함)
        // 테스트 하기 쉬운 코드를 만들려고 낮은 결합도를 가지는 코드가됨
        // 기존 코드는 강한 결합 -> 상위 인터페이스를 주입하면서 낮은 결합
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String password = passwordGenerator.generatePassword();
        /**
         * 비밀번호 8자 이상 12자 이하여야 한다.
         */
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }
}
