package com.bit.security.config;

import com.bit.security.domain.UserVO;
import com.bit.security.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.info("### authenticate ### ");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserVO user = (UserVO) userService.loadUserByUsername(username);

        // pw같은지 검증.
        if ( !passwordEncoder.matches(password,user.getPassword())) {
            throw new BadCredentialsException(username);
        }else if(!user.isEnabled()) { // 계정 활성화여부 확인
            throw new DisabledException(username);
        }else if(!user.isAccountNonExpired()) { // 계정 만료확인
            throw new AccountExpiredException(username);
        }else if(!user.isAccountNonLocked()) { // 계정 잠김확인
            throw new LockedException(username);
        }else if(!user.isCredentialsNonExpired()) { // 자격 만료확인
            throw new CredentialsExpiredException(username);
        }

        return new UsernamePasswordAuthenticationToken(user, user, user.getAuthorities());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}