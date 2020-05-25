/*
package com.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    */
/*id*//*

    @NotNull(message = "ID不能为空")
    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;

    */
/*备注描述*//*

    @TableField(value = "remark")
    protected String remark;

    */
/*所属用户ID*//*

    @TableField(value = "ownerId")
    protected Long ownerId;

    */
/*所属用户姓名*//*

    @TableField(value = "ownerName")
    protected String ownerName;

    */
/*创建者ID*//*

    @TableField(value = "createId")
    protected Long createId;

    */
/*创建者名称*//*

    @TableField(value = "createName")
    protected String createName;

    */
/*创建时间*//*

    @TableField(value = "createTime")
    protected Date createTime;

    */
/*最后更新时间*//*

    @TableField(value = "lastUpdateTime")
    protected Date lastUpdateTime;

    */
/*是否作废或者删除*//*

    @TableField(value = "isDeleted")
    protected Boolean isDeleted;

}
*/
