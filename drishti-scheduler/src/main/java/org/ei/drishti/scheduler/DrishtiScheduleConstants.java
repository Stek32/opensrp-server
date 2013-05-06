package org.ei.drishti.scheduler;

import org.joda.time.LocalTime;

public class DrishtiScheduleConstants {
    public static final LocalTime PREFERED_TIME_FOR_SCHEDULES = new LocalTime(14, 00);

    public static class ChildScheduleConstants {
        public static final String CHILD_SCHEDULE_BCG = "BCG";

        public static final String CHILD_SCHEDULE_DPT1 = "DPT 1";
        public static final String CHILD_SCHEDULE_DPT2 = "DPT 2";
        public static final String CHILD_SCHEDULE_DPT3 = "DPT 3";

        public static final String CHILD_SCHEDULE_DPT_BOOSTER1 = "DPT Booster 1";
        public static final String CHILD_SCHEDULE_DPT_BOOSTER2 = "DPT Booster 2";


        public static final String CHILD_SCHEDULE_HEPATITIS = "Hepatitis";

        public static final String CHILD_SCHEDULE_MEASLES = "Measles Vaccination";

        public static final String CHILD_SCHEDULE_MEASLES_BOOSTER = "Measles Booster";

        public static final String CHILD_SCHEDULE_OPV = "OPV";


    }

    public static class MotherScheduleConstants {
        public static final String SCHEDULE_ANC = "Ante Natal Care - Normal";
        public static final String SCHEDULE_EDD = "Expected Date Of Delivery";
        public static final String SCHEDULE_IFA = "Iron Folic Acid Supplements";
        public static final String SCHEDULE_LAB = "Lab Reminders";
        public static final String SCHEDULE_TT = "Tetatnus Toxoid Vaccination";
        public static final String SCHEDULE_AUTO_CLOSE_PNC = "Auto Close PNC";
    }

    public static class ECSchedulesConstants {
        public static final String EC_SCHEDULE_FP_COMPLICATION = "EC Family Planning Complications";
        public static final String EC_SCHEDULE_FP_COMPLICATION_MILESTONE = "FP Complications";
        public static final String EC_SCHEDULE_DMPA_INJECTABLE_REFILL = "DMPA Injectable Refill";
        public static final String EC_SCHEDULE_DMPA_INJECTABLE_REFILL_MILESTONE = "DMPA Injectable Refill";
    }


}
