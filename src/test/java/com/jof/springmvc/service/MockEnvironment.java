package com.jof.springmvc.service;

import org.springframework.core.env.Environment;

/**
 * Created by Ferenc_S on 12/19/2016.
 */
public abstract class MockEnvironment implements Environment {
    @Override
    public String[] getActiveProfiles() {
        return new String[0];
    }

    @Override
    public String[] getDefaultProfiles() {
        return new String[0];
    }

    @Override
    public boolean acceptsProfiles(String... strings) {
        return false;
    }

    @Override
    public boolean containsProperty(String s) {
        return false;
    }

    @Override
    public String getProperty(String s) {
        return null;
    }

    @Override
    public String getProperty(String s, String s1) {
        return null;
    }

    @Override
    public <T> T getProperty(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T getProperty(String s, Class<T> aClass, T t) {
        return null;
    }

    @Override
    public <T> Class<T> getPropertyAsClass(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T getRequiredProperty(String s, Class<T> aClass) throws IllegalStateException {
        return null;
    }

    @Override
    public String resolvePlaceholders(String s) {
        return null;
    }

    @Override
    public String resolveRequiredPlaceholders(String s) throws IllegalArgumentException {
        return null;
    }
}
