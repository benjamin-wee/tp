package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import seedu.address.model.tag.TodoType;

/**
 * Represents a note object in the planner.
 * Guarantees: immutable.
 */
public class Note {

    // Identity fields
    private final LocalDate date;
    private final TodoType type;
    private NoteContent note;

    /**
     * Every field must be present and not null.
     */
    public Note(NoteContent note) {
        requireAllNonNull(note);
        this.note = note;
        this.date = LocalDate.now();
        this.type = TodoType.NOTE;
    }

    /**
     * Every field must be present and not null.
     */
    public Note(NoteContent note, LocalDate date, TodoType type) {
        requireAllNonNull(note, date, type);
        this.note = note;
        this.date = date;
        this.type = type;
    }

    public NoteContent getNote() {
        return note;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getJsonDate() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
    }

    public String getDateString() {
        return DateTimeFormatter.ofPattern("dd MMM yyyy, EEEE").format(date);
    }

    public TodoType getType() {
        return type;
    }

    public void setNote(NoteContent note) {
        this.note = note;
    }

    /**
     * Returns true if both interested internship have the same title.
     * This defines a weaker notion of equality between two internships.
     */
    public boolean isSameNote(Note otherNote) {
        if (otherNote == this) {
            return true;
        }

        return otherNote != null
                && otherNote.getNote().equals(getNote());
    }

    /**
     * Returns true if both interested internships have the same fields.
     * This defines a stronger notion of equality between two internships.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Note)) {
            return false;
        }

        Note otherCompany = (Note) other;
        return otherCompany.getNote().equals(getNote())
                && otherCompany.getDate().equals(getDate());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(note, date);
    }

    @Override
    public String toString() {

        return getType() + "; Create Date: " + getDate() + "; NoteList: " + getNote();
    }
}
