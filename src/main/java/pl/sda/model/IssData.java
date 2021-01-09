
package pl.sda.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IssData {

    @SerializedName("iss_position")
    @Expose
    private IssPosition issPosition;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("timestamp")
    @Expose
    private int timestamp;

    public IssPosition getIssPosition() {
        return issPosition;
    }

    public void setIssPosition(IssPosition issPosition) {
        this.issPosition = issPosition;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "IssData{" +
                "issPosition=" + issPosition +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
