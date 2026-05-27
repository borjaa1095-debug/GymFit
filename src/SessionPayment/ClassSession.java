package SessionPayment;

import java.util.ArrayList;
import java.util.List;

public class ClassSession {

    private int sessionId;
    private String className;
    private String trainer;
    private String date;
    private int maxCapacity;
    private List<String> participants;

    public ClassSession(int sessionId, String className, String trainer, String date, int maxCapacity) {
        this.sessionId = sessionId;
        this.className = className;
        this.trainer = trainer;
        this.date = date;
        this.maxCapacity = maxCapacity;
        this.participants = new ArrayList<>();
    }

    public int getSessionId() { return sessionId; }
    public void setSessionId(int sessionId) { this.sessionId = sessionId; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getTrainer() { return trainer; }
    public void setTrainer(String trainer) { this.trainer = trainer; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public List<String> getParticipants() { return participants; }
    public boolean isFull() { return participants.size() >= maxCapacity; }

    public boolean addParticipant(String participantName) {
        boolean result = false;
        if (participants.size() >= maxCapacity) {
            System.out.println("Session already full. Cannot add " + participantName);
        } else if (participants.contains(participantName)) {
            System.out.println(participantName + " is already registered.");
        } else {
            participants.add(participantName);
            System.out.println(participantName + " registered correctly at " + className);
            result = true;
        }
        return result;
    }

    public boolean removeParticipant(String participantName) {
        boolean result = false;
        if (participants.contains(participantName)) {
            participants.remove(participantName);
            System.out.println(participantName + " deleted from the session " + className);
            result = true;
        } else {
            System.out.println(participantName + " not found on this session.");
        }
        return result;
    }

    public void displaySessionInfo() {
        System.out.println("=== Session: " + className + " ===");
        System.out.println("ID: " + sessionId);
        System.out.println("Trainer: " + trainer);
        System.out.println("Date: " + date);
        System.out.println("Capacity: " + participants.size() + "/" + maxCapacity);
        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
        } else {
            System.out.println("Participants:");
            for (String p : participants) {
                System.out.println("  - " + p);
            }
        }
    }
}