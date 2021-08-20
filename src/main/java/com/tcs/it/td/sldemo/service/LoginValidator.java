package com.tcs.it.td.sldemo.service;

import com.tcs.it.td.sldemo.dataaccess.FetchDAO;

public class LoginValidator {

    private FetchDAO fetchDAO;

    public void setFetchDAO(FetchDAO fetchDAO) {
        this.fetchDAO = fetchDAO;
    }

    public LoginValidator() {
        fetchDAO = new FetchDAO();
    }

    public boolean validateLogin(String username, String passwordHash)  {
        if(isEmpty(username) || isEmpty(passwordHash))
            return false;

        return passwordHash.equals(fetchDAO.getPasswordHash(username));
    }

    private boolean isEmpty(String anyString)   {
        return anyString == null || "".equals(anyString);
    }
}
