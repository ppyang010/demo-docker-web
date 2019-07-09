package com.code.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author ccy
 * @description
 * @time 2019/7/9 上午11:30
 */
@Getter
@AllArgsConstructor
public enum PostFromEnum {

    ZHIHU_HOT_FULL(10,"www.zhihu.com","知乎","","知乎热榜-全站")
    ;

    private Integer value;
    /**
     * 网站域名
     */
    private String host;
    /**
     * 网站名称
     */
    private String hostName;
    /**
     * 网站logo
     */
    private String logo;
    private String description;

    public static PostFromEnum valueOf(final Integer value) {
        return Arrays.stream(PostFromEnum.values()).filter(o -> Objects.equals(o.getValue(), value)).findFirst().orElse(ZHIHU_HOT_FULL);
    }

    public boolean eq(Integer value) {
        return Objects.equals(this.value, value);
    }

    public static boolean eqAny(Integer value, PostFromEnum... statuses) {
        for (PostFromEnum status : statuses) {
            if (status.eq(value)) {
                return true;
            }
        }
        return false;
    }
}
