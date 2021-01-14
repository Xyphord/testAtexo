package com.atexo.test.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by y.bobillon on 13/06/17.
 */
@RestController
public class VersionController {

    private final static Logger LOGGER = LogManager.getLogger(VersionController.class);
    private final static String BUILD_VERSION_PROPERTY = "build.version";
    private final static String APPLICATION_FILE_PROPERTY_PATH = "/build.properties";

    private static Properties contextProperties = new Properties();

    @RequestMapping(method = RequestMethod.GET, value = "/version")
    public @ResponseBody
    Map<String, Object> getVersion() throws IOException {
        LOGGER.info("##### GET VERSION START #####");
        initContext();
        String version = contextProperties.getProperty(BUILD_VERSION_PROPERTY);
        LOGGER.info(String.format("version : %s", version));
        HashMap<String, Object> map = new HashMap<>();
        map.put("version", version);
        HashMap<String, String> message = new HashMap<>();
        message.put("message","ok");
        map.put("status", message);
        LOGGER.info("##### GET VERSION END #####");
        return map;
    }

    private void initContext() throws IOException {
        URL url = this.getClass().getResource(APPLICATION_FILE_PROPERTY_PATH);
        if(url != null && url.getFile() != null) {
                contextProperties.load(url.openStream());
        }
    }
}
