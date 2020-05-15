package com.orchid.auth.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 授权范围(OauthClientScope)表实体类
 *
 * @author makejava
 * @since 2020-05-13 17:11:48
 */
@SuppressWarnings("serial")
@TableName("oauth_client_scope")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OauthClientScope extends Model<OauthClientScope> {

    //ID
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    //clientID
    @TableField("oauth_client_id")
    private Long oauthClientId;

    //编码
    @TableField("code")
    private String code;

    //名称
    @TableField("name")
    private String name;

    //自动同意 0：不自动同意；1：自动同意
    @TableField("auto_approve")
    private Integer autoApprove;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
