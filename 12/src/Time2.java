/** Represents time - hours:minutes:seconds. Values must represent a proper time.
 *
 * @author Shany Sanker 209196468
 * @version 2025B */



public class Time2 {
    private int _secFromMid;

    private static final int MIN = 0;
    private static final int MAX_HOUR = 23;
    private static final int MAX_MIN = 59;
    private static final int MAX_SEC = 59;
    private static final int MIN_TO_SEC = 60;
    private static final int HOUR_TO_SEC = 3600;

    //constructors
    /** Constructs a Time2 object.
     *  Construct a new time instance with the specified hour, minute and second.
     *  hour should be between 0-23, otherwise it should be set to 0.
     *  minute and second should be between 0-59, otherwise they should be set to 0.
     * @param h hour
     * @param m minute
     * @param s second */
    public Time2(int h, int m, int s) {
        _secFromMid = 0;

        this._secFromMid += (h < MIN || h > MAX_HOUR) ? MIN : h*HOUR_TO_SEC;
        this._secFromMid += (m < MIN || m > MAX_MIN) ? MIN : m*MIN_TO_SEC;
        this._secFromMid += (s < MIN || s > MAX_SEC) ? MIN : s;
    }

    /** Copy constructor for Time2.
     * Constructs a time with the same variables as another time.
     * @param other The time object from which to construct the new time */
    public Time2(Time2 other) {
        this._secFromMid = other._secFromMid;
    }

    //methods
    /** Returns the hour of the time. */
    public int getHour() { return _secFromMid / HOUR_TO_SEC; //primitive value no need for new
    }

    /** Returns the minute of the time. */
    public int getMinute() { return (_secFromMid % HOUR_TO_SEC) / MIN_TO_SEC;
    }

    /** Returns the second of the time. */
    public int getSecond() { return _secFromMid % MIN_TO_SEC;
    }

    // no need for this. from this point forward. written anyway for clarity.

    /** Changes the hour of the time.
     * If illegal number is received hour will remain unchanged.
     *
     * @param num The new hour */
    public void setHour(int num) {
        if (num >= MIN && num <= MAX_HOUR)
            _secFromMid += (num - getHour()) * HOUR_TO_SEC;
    }

    /** Changes the minute of the time.
     *  If illegal number is received minute will remain unchanged.
     * @param num The new minute */
    public void setMinute(int num) {
        if (num >= MIN && num <= MAX_MIN)
            _secFromMid += (num - getMinute()) * MIN_TO_SEC;
    }

    /** Changes the second of the time.
     *  If illegal number is received second will remain unchanged.
     * @param num The new second */
    public void setSecond(int num) {
        if (num >= MIN && num <= MAX_SEC)
            _secFromMid += num - getSecond();
    }

    /** @return Returns a string representation of this time (hh:mm:ss). */
    public String toString() {
        return (getHour() < 10 ? "0" : "") + getHour() + ":" + (getMinute() < 10 ? "0" : "") + getMinute() + ":" +
                (getSecond() < 10 ? "0" : "") + getSecond();
    }

    /** Calculate seconds since midnight.
     * @return Seconds passed since midnight */
    public int secFromMidnight() { return _secFromMid;
    }

    /** Checks if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time */
    public boolean equals(Time2 other) {
        return this._secFromMid == other._secFromMid;
    }

    /** Checks if this time is before a received time.
     * @param other The time to check if this time is before
     * @return True if this time is before other time */
    public boolean before(Time2 other) {
        return this._secFromMid < other._secFromMid;
    }

    /** Checks if this time is after a received time.
     * @param other The time to check if this time is after
     * @return True if this time is after other time */
    public boolean after(Time2 other) {
        return other.before(this);
    }

    /** Calculates the difference (in seconds) between two times.
     * @param other The time to check the difference with. Assumption: this time is after other time
     * @return int difference in seconds */
    public int difference(Time2 other) {
        return this._secFromMid - other._secFromMid;
    }

}
