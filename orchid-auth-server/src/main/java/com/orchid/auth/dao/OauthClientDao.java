package com.orchid.auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orchid.auth.entity.OauthClient;
import org.apache.ibatis.annotations.Select;

/**
 * 接入应用 (OauthClient)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-13 17:19:27
 */
public interface OauthClientDao extends BaseMapper<OauthClient> {

//    @Select("select * from oauth_client c left join oauth_client_scope cs on cs.oauth_client_id = c.id where c.client_id = #{clientId}")
    OauthClient loadClientByClientId(String clientId);

}
