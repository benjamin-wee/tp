package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.InternshipApplication;

/**
 * Panel containing an Internship Application with the most imminent interview.
 */
public class ReminderPanel extends UiPart<Region> {
    private static final String FXML = "Reminder.fxml";
    private final Logger logger = LogsCenter.getLogger(ReminderPanel.class);

    @FXML
    private ScrollPane container;

    /**
     * Creates a {@code ReminderPanel} with the given {@code InternshipApplication}
     */
    public ReminderPanel(InternshipApplication application) {
        super(FXML);
        if (application == null) {
            container.setContent(null);
        } else {
            container.setContent(new PersonCard(application).getRoot());
        }
    }

    /**
     * Updates the {@code ReminderPanel} with the given {@code InternshipApplication}
     */
    public void updateReminderPanel(InternshipApplication application) {
        if (application == null) {
            container.setContent(null);
        } else {
            container.setContent(new PersonCard(application).getRoot());
        }
    }
}
