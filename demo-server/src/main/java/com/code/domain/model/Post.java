package com.code.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ccy
 * @Where 注解实现全局过滤
 */
@Getter
@Setter
@Entity
@Table(name = "post")
@Accessors(chain = true)
@Where(clause = "is_deleted=0")
public class Post extends BaseDomain implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String intro;

    /**
     * url链接
     */
    private String postUrl;

    /**
     * 来源，枚举值
     */
    private Integer postFrom;

    /**
     * 作者
     */
    private String author;

    /**
     * 作者头像
     */
    private String authorAvatar;
}
