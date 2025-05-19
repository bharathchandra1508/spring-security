package com.bms.security.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationEvents.class);
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent)
    {
        LOGGER.info("Login Successful for user: "+successEvent.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failureEvent)
    {
        LOGGER.error("Login failed for user: "+failureEvent.getAuthentication().getName()+" due to "+failureEvent.getException().getMessage());
    }
}
