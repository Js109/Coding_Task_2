package mbti.coding.models;

/**
 * The class Interval represents an Interval, kind of tuple with a lowerBound and upperBound as integer
 */
public class Interval implements Comparable<Interval> {

    private int lowerBound;
    private int upperBound;

    public Interval(int lowerBound, int upperBound) {
        if (lowerBound <= upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        } else {
            this.lowerBound = upperBound;
            this.upperBound = lowerBound;
        }
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    // Since we want to sort the Intervals in the lists regarding to the lower Bounds we override the compareTo method here
    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.lowerBound, other.lowerBound);
    }

    // This equals method defines in which case an Object of type Interval is equal to another Object of type Interval (needed for UnitTests)
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Interval interval)) return false;
        return this.lowerBound == interval.getLowerBound() &&
                this.upperBound == interval.getUpperBound();
    }

    @Override
    public String toString() {
        return "[" + lowerBound +
                "," + upperBound +
                ']';
    }

}
