package org.marsken.plantform.domain.constant;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/5 11:16 下午
 * @description：
 * @modified By：
 * @version: $
 */
public enum JudgeEnum implements BaseEnum {
    NO(0, "否"),

    YES(1, "是");

    private Integer value;
    private String desc;

    JudgeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public static JudgeEnum valueOf(Integer status) {
        JudgeEnum[] values = JudgeEnum.values();
        Optional<JudgeEnum> first = Arrays.stream(values).filter(e -> e.getValue().equals(status)).findFirst();
        return !first.isPresent() ? null : first.get();
    }

    public static boolean isExist(Integer status) {
        JudgeEnum judgeEnum = valueOf(status);
        return judgeEnum != null;
    }
}
