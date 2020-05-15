package com.orchid.auth.config;

import com.orchid.auth.service.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private TokenStore tokenStore;


    @Autowired
    private AccessTokenConverter accessTokenConverter;


    @Autowired
    private OauthClientService oauthClientService;

    /**
     * 1、授权服务端点设置
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //指定用户认证管理器
        endpoints.authenticationManager(authenticationManager)
	            .tokenStore(tokenStore)
                .accessTokenConverter(accessTokenConverter);

    }



    /**
     * 2、授权服务端点安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
            // jwt获取令牌key端点不要认证
            .tokenKeyAccess("permitAll()")
            //校验令牌端点需要授权过
            .checkTokenAccess("isAuthenticated()")
            .allowFormAuthenticationForClients();
    }


    /**
     * 客户端设置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(oauthClientService);
    }


}




