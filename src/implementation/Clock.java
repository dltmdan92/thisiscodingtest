package implementation;

public class Clock {

    public static void main(String[] args) {
        int N = 23;
        ClockNode start = new ClockNode(N);
        int count = 0;

        while (true) {
            if (start.hasThree()) {
                count++;
            }
            try {
                start.plusOneSecond();
            } catch (HourValueOverException e) {
                break;
            }
        }

        System.out.println(count);
    }

    public static class ClockNode {
        private final int HOUR_MAX;
        private static final int SECOND_MAX = 59;
        private static final int MINUTE_MAX = 59;

        private int hour;
        private int minute;
        private int second;

        public ClockNode(int hourMax) {
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
            this.HOUR_MAX = hourMax;
        }

        public boolean hasThree() {
            return hourHasThree() || minuteHasThree() || secondHasThree();
        }

        private boolean secondHasThree() {
            return this.second % 10 == 3 || this.second / 10 == 3;
        }

        private boolean minuteHasThree() {
            return this.minute % 10 == 3 || this.minute / 10 == 3;
        }

        private boolean hourHasThree() {
            return this.hour % 10 == 3;
        }

        public void plusOneSecond() {
            if (second + 1 > SECOND_MAX) {
                this.second = 0;
                plusOneMinute();
            } else {
                this.second++;
            }
        }

        private void plusOneMinute() {
            if (minute + 1 > MINUTE_MAX) {
                this.minute = 0;
                plusOneHour();
            } else {
                this.minute++;
            }
        }

        private void plusOneHour() {
            if (hour + 1 > HOUR_MAX) {
                throw new HourValueOverException();
            } else {
                this.hour++;
            }
        }
    }

    public static class HourValueOverException extends RuntimeException {

    }

}
