package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.InternshipApplication;

import java.util.logging.Logger;

public class ReminderPanel extends UiPart<Region> {
    private final static String FXML = "Reminder.fxml";
    private final Logger logger = LogsCenter.getLogger(ReminderPanel.class);

    @FXML
    private ScrollPane container;

    public ReminderPanel(InternshipApplication application) {
        super(FXML);
        if (application == null) {
            container.setContent(null);
        } else {
            container.setContent(new PersonCard(application).getRoot());
        }
    }

    public void updateReminderPanel(InternshipApplication application) {
        if (application == null) {
            container.setContent(null);
        } else {
            container.setContent(new PersonCard(application).getRoot());
        }
    }
}
