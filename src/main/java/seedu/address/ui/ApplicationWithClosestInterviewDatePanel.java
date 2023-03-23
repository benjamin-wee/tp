package seedu.address.ui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.model.ModelManager;
import seedu.address.model.person.InternshipApplication;

import java.util.logging.Logger;

public class ApplicationWithClosestInterviewDatePanel extends UiPart<Region> {
    private final static String FXML = "ApplicationWithClosestInterviewDatePanel";
    private final Logger logger = LogsCenter.getLogger(ApplicationWithClosestInterviewDatePanel.class);

    @FXML
    private TitledPane closestUpcomingApplication;

    public ApplicationWithClosestInterviewDatePanel() {
        super(FXML);
        closestUpcomingApplication.setText("Earliest Upcoming Interview");
        closestUpcomingApplication.setContent(new PersonListPanel.PersonListViewCell());
    }
}
