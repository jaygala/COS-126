public class NoonSnooze {
    public static void main(String[] args) {
        int snooze = Integer.parseInt(args[0]);
        String am_pm = "pm";
        int TOTAL_MINUTES = 60;
        int TOTAL_HOURS = 12;
        int hours = TOTAL_HOURS + snooze / TOTAL_MINUTES;
        int minutes = snooze % TOTAL_MINUTES;   //  contains the minute past the hour
        int hour_value = (hours + TOTAL_HOURS) % TOTAL_HOURS;

        //  This is to ensure that the am and pm works correctly
        if ((hours / TOTAL_HOURS) % 2 == 0) {
            am_pm = "am";
        }

        if (hour_value == 0) {
            if (minutes
                    < 10) {     //  This extra if condition is for displaying double digit minutes (if the minutes is single digit)
                System.out.println(TOTAL_HOURS + ":" + "0" + minutes + am_pm);
            }
            else {
                System.out.println(TOTAL_HOURS + ":" + minutes + am_pm);
            }
        }
        else {
            if (minutes < 10) {
                System.out.println(hour_value + ":" + "0" + minutes + am_pm);
            }
            else {
                System.out.println(hour_value + ":" + minutes + am_pm);
            }
        }


    }
}
