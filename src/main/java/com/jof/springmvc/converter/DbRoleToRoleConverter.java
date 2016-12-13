package com.jof.springmvc.converter;

import com.jof.springmvc.model.Role;
import com.jof.springmvc.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class DbRoleToRoleConverter implements Converter<Object, Role> {

    static final Logger logger = LoggerFactory.getLogger(DbRoleToRoleConverter.class);

    @Autowired
    RoleService roleService;

    /**
     * Gets Role by Id
     *
     * @see Converter#convert(Object)
     */
    public Role convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Role profile = roleService.findById(id);
        logger.info("Profile : {}", profile);
        return profile;
    }

}