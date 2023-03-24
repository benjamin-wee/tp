package seedu.address.model.person;

import java.util.List;

public class UpcomingInterviewTracker {

    public final List<InternshipApplication> applications;

    public UpcomingInterviewTracker(List<InternshipApplication> applications) {
        this.applications = applications;
    }
    public InternshipApplication getClosestUpcomingApplication() {
        if (applications == null || applications.isEmpty()) {
            return null;
        }
        InternshipApplication closestApplication = applications.get(0);

        for (int i = 1; i < applications.size(); i++) {
            InternshipApplication application = applications.get(i);
            if (application.getInterviewDate().isBeforeInclusive(closestApplication.getInterviewDate())) {
                closestApplication = application;
            }
        }
        return closestApplication;
    }
}
