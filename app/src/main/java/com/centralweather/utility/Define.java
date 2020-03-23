package com.centralweather.utility;

/**
 * Created by Amber_Chen on 2020-03-21.
 */
public class Define {
    public static final String SPFS_CATEGORY = "SpfsUserInfo";
    public static final String SPFS_LAUNCH_STATUS = "SpfsLaunchStatus";

    /* CityType Type */
    public enum CityType {
        TAIPEI("臺北市");

        public String city = "";

        CityType(String city) {
            this.city = city;
        }
    }

    /* ElementType Type */
    public enum ElementType {
        MIN_T("MinT");

        public String element = "";

        ElementType(String element) {
            this.element = element;
        }
    }

}
