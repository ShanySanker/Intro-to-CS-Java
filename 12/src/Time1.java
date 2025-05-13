/** Represents time - hours:minutes:seconds. Values must represent a proper time.
 *
 * @author Shany Sanker 209196468
 * @version 2025 */


public class Time1 {
    private int _hour;
    private int _minute;
    private int _second;

    private static final int MIN = 0;
    private static final int MAX_HOUR = 23;
    private static final int MAX_MIN = 59;
    private static final int MAX_SEC = 59;
    private static final int MIN_TO_SEC = 60;
    private static final int HOUR_TO_SEC = 3600;

    //constructors
    /** Constructs a Time1 object.
     * Constructs a new time instance with the specified hour, minute and second.
     * hour should be between 0-23, otherwise it should be set to 0.
     * minute and second should be between 0-59, otherwise they should be set to 0.
     *
     * @param h hour
     * @param m minute
     * @param s second */
    public Time1(int h, int m, int s) {
        this._hour = (h < MIN || h > MAX_HOUR) ? 0 : h;
        this._minute = (m < MIN || m > MAX_MIN) ? 0 : m;
        this._second = (s < MIN || s > MAX_SEC) ? 0 : s;
    }

    /** Copy constructor for Time1.
     * Constructs a time with the same variables as another time.
     *
     * @param other to be copied */
    public Time1(Time1 other) {
        this._hour = other._hour;
        this._minute = other._minute;
        this._second = other._second;
    }

    //methods
    /** Returns the hour of the time. */
    public int getHour() { return _hour; //primitive value no need for new
    }

    /** Returns the minute of the time. */
    public int getMinute() { return _minute;
    }

    /** Returns the second of the time. */
    public int getSecond() { return _second;
    }

    // no need for this. from this point forward. written anyway for clarity.

    /** Changes the hour of the time.
     * If illegal number is received hour will remain unchanged.
     *
     * @param num The new hour */
    public void setHour(int num) {
        if (num >= MIN && num <= MAX_HOUR)
            this._hour = num;
    }

    /** Changes the minute of the time.
     *  If illegal number is received minute will remain unchanged.
     * @param num The new minute */
    public void setMinute(int num) {
        if (num >= MIN && num <= MAX_MIN)
            this._minute = num;
    }

    /** Changes the second of the time.
     *  If illegal number is received second will remain unchanged.
     * @param num The new second */
    public void setSecond(int num) {
        if (num >= MIN && num <= MAX_SEC)
            this._second = num;
    }

    /** @return Returns a string representation of this time (hh:mm:ss). */
    public String toString() {
        return (_hour < 10 ? "0" : "") + _hour + ":" + (_minute < 10 ? "0" : "") + _minute + ":" +
                (_second < 10 ? "0" : "") + _second;
    }

    /** Calculate seconds since midnight.
     * @return Seconds passed since midnight */
    public int secFromMidnight() {
        return this._hour * HOUR_TO_SEC + this._minute * MIN_TO_SEC + this._second;

    }

    /** Checks if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time */
    public boolean equals(Time1 other) {
        return (this._hour == other._hour) && (this._minute == other._minute) && (this._second == other._second);

    }

    /** Checks if this time is before a received time.
     * @param other The time to check if this time is before
     * @return True if this time is before other time */
    public boolean before(Time1 other) {
        return this.secFromMidnight() < other.secFromMidnight();
    }

    /** Checks if this time is after a received time.
     * @param other The time to check if this time is after
     * @return True if this time is after other time */
    public boolean after(Time1 other) {
        return other.before(this);
    }

    /** Calculates the difference (in seconds) between two times.
     * @param other The time to check the difference with. Assumption: this time is after other time
     * @return int difference in seconds */
    public int difference(Time1 other) {
        return this.secFromMidnight()-other.secFromMidnight();
    }

}
