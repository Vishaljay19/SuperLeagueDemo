package com.tcs.it.td.sldemo.service;

import com.tcs.it.td.sldemo.dataaccess.FetchDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginValidatorTest {

    public LoginValidator loginValidator = new LoginValidator();

    @BeforeEach()
    void setupMock()    {
        FetchDAO fetchDAO = mock(FetchDAO.class);
        when(fetchDAO.getPasswordHash(eq("InValidUser"))).thenReturn("");
        when(fetchDAO.getPasswordHash(eq("ValidUser"))).thenReturn("ValidPasswordHash");
        loginValidator.setFetchDAO(fetchDAO);
    }

    @Test
    void validateLoginUserNull() {
        assert !loginValidator.validateLogin("", "ValidPasswordHash");
    }

    @Test
    void validateLoginPassNull() {
        assert !loginValidator.validateLogin("ValidUser", null);
    }

    @Test
    void validateLoginAllNull() {
        assert !loginValidator.validateLogin(null, "");
    }

    @Test
    void validateLoginInvalidUser() {
        assert !loginValidator.validateLogin("InValidUser", "ValidPasswordHash");
    }

    @Test
    void validateLoginFailure() {
        assert !loginValidator.validateLogin("ValidUser", "InValidPasswordHash");
    }

    @Test
    void validateLoginSuccess() {
        assert loginValidator.validateLogin("ValidUser", "ValidPasswordHash");
    }
}