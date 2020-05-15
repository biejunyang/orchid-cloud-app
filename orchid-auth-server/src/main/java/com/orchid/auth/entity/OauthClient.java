package com.orchid.auth.entity;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.orchid.mybatis.entity.BaseEntity;
import com.orchid.mybatis.handler.StringSetTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 接入应用 (OauthClient)表实体类
 *
 * @author makejava
 * @since 2020-05-13 17:19:27
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(resultMap = "ClientResultMap")
public class OauthClient extends BaseEntity<OauthClient> implements ClientDetails {

    //编码
    @TableField("client_id")
    private String clientId;

    //凭证
    @TableField("client_secret")
    private String clientSecret;

    //允许的登录方式("authorization_code","password", "client_credentials", "implicit", "refresh_token")
//    @TableField(typeHandler = StringSetTypeHandler.class)
    private Set<String> authorizedGrantTypes;


//    @TableField(typeHandler = StringSetTypeHandler.class)
    private Set<String> redirectUris;


    private Integer accessTokenValiditySeconds = 60 * 60 * 13;

    private Integer refreshTokenValiditySeconds = 60 * 60 * 25;


    @TableField(exist = false)
    private List<OauthClientScope> clientScopes=CollectionUtil.newArrayList();


    @TableField(exist = false)
    private Set<String> resourceIds= CollectionUtil.newHashSet();

    @TableField(exist = false)
    private List<GrantedAuthority> authorities = CollUtil.newLinkedList();

    @TableField(exist = false)
    private Map<String, Object> additionalInformation = CollUtil.newHashMap();



    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public Set<String> getResourceIds() {
        return resourceIds;
    }

    @Override
    public boolean isSecretRequired() {
        return StrUtil.isNotBlank(clientSecret);
    }

    @Override
    public boolean isScoped() {
        return CollectionUtil.isNotEmpty(clientScopes);
    }

    @Override
    public Set<String> getScope() {
        return clientScopes.parallelStream().map(OauthClientScope::getCode).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return CollectionUtil.newHashSet(this.redirectUris);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAutoApprove(String s) {
        for (OauthClientScope scope : clientScopes) {
            if (StrUtil.equals(scope.getCode(), s)) {
                return scope.getAutoApprove().equals(1);
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }
}
