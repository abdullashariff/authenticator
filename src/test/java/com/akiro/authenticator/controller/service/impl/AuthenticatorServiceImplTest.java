package com.akiro.authenticator.controller.service.impl;

import com.akiro.authenticator.controllers.service.impl.AuthenticatorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith(PowerMockRunner.class)
@ContextConfiguration
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthenticatorServiceImplTest {

    @InjectMocks
    AuthenticatorServiceImpl authenticatorServiceImpl;

    @Test
    public void testGenerateToken() {
        authenticatorServiceImpl.generateAuthToken("024790");
    }
}
