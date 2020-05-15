package com.orchid.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orchid.auth.dao.OauthClientScopeDao;
import com.orchid.auth.entity.OauthClientScope;
import com.orchid.auth.service.OauthClientScopeService;
import org.springframework.stereotype.Service;

/**
 * 授权范围(OauthClientScope)表服务实现类
 *
 * @author makejava
 * @since 2020-05-13 17:11:48
 */
@Service("oauthClientScopeService")
public class OauthClientScopeServiceImpl extends ServiceImpl<OauthClientScopeDao, OauthClientScope> implements OauthClientScopeService {

}