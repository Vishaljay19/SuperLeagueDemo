package com.tcs.it.td.sldemo.dataaccess;

import org.junit.jupiter.api.Test;


class FetchDAOTest {

    FetchDAO fetchDAO = new FetchDAO();

    @Test
    void validateLogin() {
        assert "somepasswordhash".equals(fetchDAO.getPasswordHash("SomeUser"));
    }

    @Test
    void validateLogin2() {
        assert "somepasswordhash".equals(fetchDAO.getPasswordHash("SomeOtherUser"));
    }

}