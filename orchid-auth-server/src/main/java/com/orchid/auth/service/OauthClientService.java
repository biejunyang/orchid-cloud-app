package com.orchid.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orchid.auth.entity.OauthClient;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * 接入应用 (OauthClient)表服务接口
 *
 * @author makejava
 * @since 2020-05-13 17:19:27
 */
public interface OauthClientService extends IService<OauthClient>, ClientDetailsService {

}
