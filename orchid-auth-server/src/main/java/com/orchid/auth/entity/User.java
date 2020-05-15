package com.orchid.auth.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.orchid.mybatis.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2020-04-15 15:42:54
 */
@SuppressWarnings("serial")
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity<User>implements UserDetails {


    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("state")
    private Integer state;


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.state.equals(3);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.state.equals(2);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.state.equals(1);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }



}
