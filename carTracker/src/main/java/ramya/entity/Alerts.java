package ramya.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Alerts {

    @Id
    private String alertid;

    private String description;
    private String priority;
    private String timestamp;

    public Alerts(String timestamp) {
        this.alertid = UUID.randomUUID().toString();
        this.timestamp = timestamp;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAlertid() {
        return alertid;
    }

    public void setAlertid(String alertid) {
        this.alertid = alertid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }



    @Override
    public String toString() {
        return "Alerts{" +
                "alertid='" + alertid + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
