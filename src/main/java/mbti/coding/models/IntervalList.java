package mbti.coding.models;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The class IntervalList represents an ArrayList with the generic data type Interval.
 * The required function merge is implemented on this interval list.
 */
public class IntervalList extends ArrayList<Interval> {

    /**
     * The method merge() can be executed on an IntervalList. It in turn returns an IntervalList.
     * The result contains all overlapping intervals that are merged.
     * All non-overlapping intervals remain untouched.
     *
     * @return IntervalList containing all overlapping intervals that are merged
     */
    public IntervalList merge() {
        IntervalList intervalList = this;
        // return basic cases before sorting the list
        if (intervalList.isEmpty()) {
            return new IntervalList();
        }
        if (intervalList.size() == 1) {
            return intervalList;
        }
        // sort the interval list according to ascending order with comparison criterion lowerBound - defined in compareTo method in Interval class
        Collections.sort(intervalList);

        IntervalList resultIntervalList = new IntervalList();
        // Initialize current element to first interval
        Interval currentInterval = intervalList.get(0);

        // mergeCandidateIndex is 1 at the beginning because we compare the current interval with the following interval of the sorted list
        for (int mergeCandidateIndex = 1; mergeCandidateIndex < intervalList.size(); mergeCandidateIndex++) {
            Interval possibleNextMergeCandidate = intervalList.get(mergeCandidateIndex);
            if (currentInterval.getUpperBound() >= possibleNextMergeCandidate.getLowerBound()) {
                // if upperBound is bigger or equal than the lower Bound of the next interval we check if the upperBound is also bigger than the upperBound of the next interval
                if (currentInterval.getUpperBound() < possibleNextMergeCandidate.getUpperBound()) {
                    // if it is bigger we set it as the new upperBound
                    currentInterval.setUpperBound(possibleNextMergeCandidate.getUpperBound());
                }
            } else {
                // if the current upperBound is smaller than the next lowerBound we add the interval to the result list
                resultIntervalList.add(currentInterval);
                // and proceed with the next interval in the for loop
                currentInterval = possibleNextMergeCandidate;
            }
        }
        // add the last interval to the result list
        resultIntervalList.add(currentInterval);
        return resultIntervalList;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
