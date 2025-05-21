package com.bms.security.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationEvents
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationEvents.class);

    @EventListener
    public void onFailure(AuthorizationDeniedEvent deniedEvent)
    {
        LOGGER.error("Authorization failed for user: "+deniedEvent.getAuthentication().get().getName()+" due to "+deniedEvent.getAuthorizationDecision().toString());
    }
}
