package seedu.address.model.application.exceptions;

/**
 * Signals that the operation will result in duplicate InternshipApplications.
 */
public class DuplicateApplicationException extends RuntimeException {
    public DuplicateApplicationException() {
        super("Operation would result in duplicate persons");
    }
}
