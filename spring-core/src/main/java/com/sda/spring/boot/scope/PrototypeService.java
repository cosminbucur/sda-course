package com.sda.spring.boot.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
public class PrototypeService {
}
