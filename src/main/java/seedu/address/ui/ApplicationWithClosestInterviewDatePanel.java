package seedu.address.ui;

import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.InternshipApplication;
import seedu.address.model.person.UpcomingInterviewTracker;

import java.util.logging.Logger;

public class ApplicationWithClosestInterviewDatePanel extends UiPart<Region> {
    private final static String FXML = "ApplicationWithClosestInterviewDatePanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ApplicationWithClosestInterviewDatePanel.class);

    @FXML
    private ScrollPane container;

    public ApplicationWithClosestInterviewDatePanel(ObservableList<InternshipApplication> applications) {
        super(FXML);
        UpcomingInterviewTracker tracker = new UpcomingInterviewTracker(applications);
        InternshipApplication closestApplication = tracker.getClosestUpcomingApplication();
        container.setContent(new PersonCard(closestApplication).getRoot());
    }
}
