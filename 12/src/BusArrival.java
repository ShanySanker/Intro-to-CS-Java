/** Represents a BusArrival. BusArrival is represented by its line number, arrival time, number Of passengers.
 *
 * @author Shany Sanker 209196468
 * @version 2025B */


public class BusArrival {
    private int _lineNumber;
    private Time1 _arrivalTime;
    private int _noOfPassengers;

    private static final int MIN_LINE = 1;
    private static final int MAX_LINE = 99;
    private static final int MIN_NO = 0;
    private static final int MAX_NO = 70;
    private static final int MIN_TO_SEC = 60;

    //constructors
    /** Constructs a BusArrival object.
     * with line number, number of passengers, and time(hour, minute and second) of arrival
     * if lineNum is illegal it will be set to 1. if other parameters are illegal they will be set to 0.
     * @param lineNum The bus line number (should be between 1-99)
     * @param pass The number of passengers (should be between 0-70)
     * @param h The hour of bus arrival (should be between 0-23)
     * @param m The minute of bus arrival (should be between 0-59)
     * @param s The second of bus arrival (should be between 0-59)
     * */
    public BusArrival(int lineNum, int pass, int h, int m, int s) {
        this._lineNumber = (lineNum < MIN_LINE || lineNum > MAX_LINE) ? 1 : lineNum;
        this._arrivalTime = new Time1(h, m, s); //time 1 is not primitive
        this._noOfPassengers = (pass < MIN_NO || pass > MAX_NO) ? 0 : pass;
    }
    /** Constructs BusArrival object.
     * with line number, number of passengers, and time of arrival if lineNum is illegal it will be set to 1.
     * if pass is illegal it will be set to 0.
     * @param lineNum The bus line number (should be between 1-99)
     * @param pass The number of passengers (should be between 0-70)
     * @param t The time of bus arrival */
    public BusArrival(int lineNum, int pass, Time1 t) {
        this._lineNumber = (lineNum < MIN_LINE || lineNum > MAX_LINE) ? 1 : lineNum;
        this._arrivalTime = new Time1(t);
        this._noOfPassengers = (pass < MIN_NO || pass > MAX_NO) ? 0 : pass;
    }

    /** Copy constructor for a BusArrival.
     * Constructs a BusArrival with the same attributes as another BusArrival.
     * @param other The BusArrival object from which to construct the new BusArrival. */
    public BusArrival (BusArrival other) {
        this._lineNumber = other._lineNumber;
        this._arrivalTime = new Time1(other._arrivalTime);
        this._noOfPassengers = other._noOfPassengers;
    }

    //methods
    /** Returns the bus arrival time. */
    public Time1 getArrivalTime() { return new Time1(this._arrivalTime); //not primitive value, there's need for new
    }

    /** Returns the bus line number. */
    public int getLineNum() {
        return _lineNumber;
    }

    /** Returns the number of passengers. */
    public int getNoOfPass() {
        return _noOfPassengers;
    }


    // no need for this. from this point forward. written anyway for clarity.

    /** Changes the BusArrival's time
     * @param t The BusArrival's new time. */
    public void setArrivalTime(Time1 t) {
        this._arrivalTime = new Time1(t);
    }

    /** Changes the BusArrival's line number.
     * if the parameter is illegal the line number will remain unchanged
     * @param num The BusArrival's new line number. */
    public void setLineNum(int num) {
        if (num >= MIN_LINE && num <= MAX_LINE)
            this._lineNumber = num;
    }

    /** Changes the BusArrival's number of passengers.
     * if the parameter is illegal the number of passengers will remain unchanged
     * @param num The BusArrival's new number of passengers. */
    public void setNoOfPass(int num) {
        if (num >= MIN_NO && num <= MAX_NO)
            this._noOfPassengers = num;
    }

    /** @return a string representation of this BusArrival */
    public String toString() {
        return "Bus no. " + _lineNumber + " arrived at " + _arrivalTime +" with " + _noOfPassengers + " passengers";
    }

    /** Checks if this bus's number of passengers is equal to the maximum number of passengers allowed.
     * @return true if this bus's number of passengers is equal to the maximum number of passengers allowed. false otherwise */
    public boolean isFull() {
        return (this._noOfPassengers == MAX_NO);
    }

    /** Checks if the received BusArrival is equal to this BusArrival.
     * @param other The BusArrival to be compared with this BusArrival
     * @return true if the received BusArrival is equal to this BusArrival */
    public boolean equals(BusArrival other) {
        return ((this._lineNumber==other._lineNumber) && (this._arrivalTime.equals(other._arrivalTime))
                && (this._noOfPassengers==other._noOfPassengers));

    }

    /** Checks if this bus's arrival time is before other bus's arrival time.
     * @param other The BusArrival to be compared with this BusArrival
     * @return true if this bus's arrival time is before other bus's arrival time. false otherwise */
    public boolean before(BusArrival other) {
        return this._arrivalTime.before(other._arrivalTime);
    }

    /** Checks if this bus's number of passengers is larger than other bus's number of passengers.
     * @param other The BusArrival to be compared with this BusArrival
     * @return true if this bus's number of passengers is larger than other bus's number of passengers. false otherwise */
    public boolean fuller(BusArrival other) {
        return this._noOfPassengers > other._noOfPassengers;

    }

    /** Calculates the difference (in minutes) between this bus arrival time and other.
     * @param other The time to check the difference with.
     * @return int difference in minutes */
    public int elapsedTime(BusArrival other) {
        return Math.abs(this._arrivalTime.difference(other._arrivalTime))/MIN_TO_SEC;
    }

}
