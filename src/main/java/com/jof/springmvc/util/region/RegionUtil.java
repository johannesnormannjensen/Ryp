package com.jof.springmvc.util.region;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class RegionUtil {

    static final Logger logger = LoggerFactory.getLogger(RegionUtil.class);

    public static List<Region> getRegions() {
        return Arrays.asList(Region.class.getEnumConstants());
    }

    public static boolean validate(String regionName, HttpServletRequest request) {
        for (Region region : getRegions()) {
            if (region.name().equals(regionName)) {
                return true;
            }
        }
        logger.info(request.getParameter("username") + " tried logging into unexisting region: " + regionName);
        throw new InvalidRegionException(regionName);
    }

    private enum Region {
        EUNE, EUW
    }
}
