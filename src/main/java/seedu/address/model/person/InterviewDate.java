package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an InternshipApplication's interviewDate in the tracker.
 */
public class InterviewDate extends InternshipApplicationAttribute {

    public static final String MESSAGE_CONSTRAINTS = "Interview dates should be of the format 'yyyy-MM-dd hh:mm a'.";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
    public final LocalDateTime value;

    /**
     * Constructs an {@code InterviewDate}.
     *
     * @param interviewDate A valid date-string.
     */
    public InterviewDate(String interviewDate) {
        requireNonNull(interviewDate);
        checkArgument(isValidInterviewDate(interviewDate), MESSAGE_CONSTRAINTS);
        value = LocalDateTime.parse(interviewDate, FORMATTER);
    }

    /**
     * Returns if a given LocalDateTime is valid or null (ie interviewDate has not been added).
     */
    public static boolean isValidInterviewDate(String test) {
        if (test == null) {
            return true;
        }
        try {
            LocalDateTime.parse(test, FORMATTER);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if this {@code InterviewDate} is before the specified {@code InterviewDate} (inclusive).
     *
     * @param interviewDate The other date to compare to
     * @return true if this date is before the {@code interviewDate} (inclusive)
     */
    public boolean isBeforeInclusive(InterviewDate interviewDate) {
        return value.isBefore(interviewDate.value) || value.isEqual(interviewDate.value);
    }

    /**
     * Checks if this {@code InterviewDate} is after the specified {@code InterviewDate} (inclusive).
     *
     * @param interviewDate The other date to compare to
     * @return true if this date is after the {@code interviewDate} (inclusive)
     */
    public boolean isAfterInclusive(InterviewDate interviewDate) {
        return value.isAfter(interviewDate.value) || value.isEqual(interviewDate.value);
    }

    /**
     * Checks if this {@code InterviewDate} is between the specified {@code InterviewDate}'s (both inclusive).
     *
     * @param startDate The start date of the period
     * @param endDate The end date of the period
     * @return true if this date lies between both dates (both inclusive)
     */
    public boolean isBetweenInclusive(InterviewDate startDate, InterviewDate endDate) {
        return isAfterInclusive(startDate) && isBeforeInclusive(endDate);
    }

    @Override
    public String toString() {
        return value.format(FORMATTER);
    }
    
    public LocalDateTime getDateTime() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && value.equals(((Email) other).value)); // state check
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
