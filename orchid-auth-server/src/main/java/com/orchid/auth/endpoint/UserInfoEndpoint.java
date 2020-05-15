package com.orchid.auth.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FrameworkEndpoint
@AllArgsConstructor
public class UserInfoEndpoint {

    @GetMapping("/userinfo")
    @ResponseBody
    public Object userinfo(AbstractAuthenticationToken token) {
        return token.getPrincipal();
    }
}
