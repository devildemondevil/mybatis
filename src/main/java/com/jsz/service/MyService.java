package com.jsz.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface MyService {

    @Transactional(rollbackFor = {IOException.class},propagation = Propagation.REQUIRES_NEW)
    public void transfer();
}
