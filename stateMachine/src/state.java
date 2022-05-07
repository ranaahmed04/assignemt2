public class state {

    public String state = "NORMAL"; // initial state
    public String state1 = "TIME";
    public int minute=0, hour=0,day=1,Month=1,year=2000;

    public String[] InState(char input)
    {

        if(state.equals("NORMAL"))
            {
                if(input=='c'){
                        state = "UPDATE";
                        state1 = "min";
                    }
                if(input=='b'){
                        state = "ALARM";
                        state1 = "Alarm";

                    }
                if(input=='a') {
                        if (state1.equals("TIME")) {
                            state1 = "DATE";
                        } else {
                            state1 = "TIME";
                        }

                    }
                }


        if (state.equals("UPDATE")) {
            if (input == 'd') {
                state = "NORMAL";
                state1 = "TIME";
            }

            if (input == 'a') {
                if (state.equals("year")) {
                    state = "NORMAL";
                    state1 = "TIME";
                }
                if (state1.equals("month")) {
                    state1 = "year";
                }
                if (state1.equals("day")) {
                    state1 = "month";
                }
                if (state1.equals("hour")) {
                    state1 = "day";
                }
                if (state1.equals("min")) {
                    state1 = "hour";
                }
            }

            if (input == 'b') {
                if (state1.equals("min")) {
                    minute++;
                    if (minute>= 60) {
                        minute= 0;
                    }
                }
                if (state1.equals("hour")) {
                    hour++;
                    if (hour >= 24) {
                        hour = 0;
                    }
                }
                if (state1.equals("day")) {
                    day++;
                    if (day > 31) {
                        day = 1;
                    }
                }
                if (state1.equals("month")) {
                    Month++;
                    if (Month > 12) {
                        Month = 1;
                    }
                }
                if (state1.equals("year")) {
                    year++;
                    if (year > 2100) {
                        year = 2000;
                    }
                }
            }
        }
        if (state.equals("ALARM")) {
            switch(input) {
                case 'd':{

                    state = "NORMAL";
                    state1 = "TIME";
                }
                case 'a':{

                    state1 = "Chime";
                }
            }
        }

        return new String[]{state, state1, String.valueOf(year) +
                "-" + String.valueOf(Month) + "-" + String.valueOf(day),
                String.valueOf(hour) + ":" + String.valueOf(minute)};



    }
}
