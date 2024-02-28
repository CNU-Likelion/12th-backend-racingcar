package racingcar;

import org.junit.platform.commons.util.StringUtils;

import java.lang.*;
public class Name {
    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(("이름은 빈 값이 될 수 없습니다"));
        }
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
