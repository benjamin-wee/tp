package seedu.address.model;

import seedu.address.model.person.InternshipApplication;

import java.util.List;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class Reminder {
    private InternshipApplication upcomingApplication;
    private final List<InternshipApplication> applications;

    public Reminder(List<InternshipApplication> applications) {
        requireAllNonNull(applications);
        this.applications = applications;
        this.upcomingApplication = null;
    }

    public InternshipApplication getClosestUpcomingInterview() {
        return upcomingApplication;
    }

    public void setClosestUpcomingInterview() {
        if (applications == null || applications.isEmpty()) {
            this.upcomingApplication = null;
        } else {
            InternshipApplication closestApplication = applications.get(0);

            for (int i = 1; i < applications.size(); i++) {
                InternshipApplication application = applications.get(i);
                if (application.getInterviewDate() != null && closestApplication.getInterviewDate() == null) {
                    closestApplication = application;
                }
                if (application.getInterviewDate() != null && application.getInterviewDate().isBeforeInclusive(closestApplication.getInterviewDate())) {
                    closestApplication = application;
                }
            }
            if (closestApplication.getInterviewDate() == null) {
                this.upcomingApplication = null;
            } else {
                this.upcomingApplication = closestApplication;
            }
        }
    }
}
