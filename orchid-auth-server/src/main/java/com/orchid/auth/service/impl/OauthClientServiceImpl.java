package com.orchid.auth.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orchid.auth.dao.OauthClientDao;
import com.orchid.auth.entity.OauthClient;
import com.orchid.auth.service.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

/**
 * 接入应用 (OauthClient)表服务实现类
 *
 * @author makejava
 * @since 2020-05-13 17:19:27
 */
@Service("oauthClientsService")
public class OauthClientServiceImpl extends ServiceImpl<OauthClientDao, OauthClient> implements OauthClientService {


    @Autowired
    private OauthClientDao oauthClientDao;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClient client=oauthClientDao.loadClientByClientId(clientId);
        if(client==null) {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
        return client;
    }
}
