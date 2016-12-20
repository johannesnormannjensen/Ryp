package com.jof.springmvc.xray;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.amazonaws.services.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.plugins.ElasticBeanstalkPlugin;

public class AWSXRayServletContext implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Initialize AWS XRay Recorder before any filters or servlets are created
        AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard().withPlugin(new ElasticBeanstalkPlugin());
        com.amazonaws.xray.AWSXRay.setGlobalRecorder(builder.build());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
