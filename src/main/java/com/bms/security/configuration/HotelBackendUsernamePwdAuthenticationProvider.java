package com.bms.security.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HotelBackendUsernamePwdAuthenticationProvider implements AuthenticationProvider
{

    private final HotelBackendUserDetailsService hotelBackendUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public HotelBackendUsernamePwdAuthenticationProvider(HotelBackendUserDetailsService hotelBackendUserDetailsService, PasswordEncoder passwordEncoder)
    {
        this.hotelBackendUserDetailsService = hotelBackendUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        UserDetails userDetails = hotelBackendUserDetailsService.loadUserByUsername(username);
        if(passwordEncoder.matches(pwd, userDetails.getPassword()))
        {
            return new UsernamePasswordAuthenticationToken(username,pwd,userDetails.getAuthorities());
        }
        else
        {
            throw new BadCredentialsException("Invalid Password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
