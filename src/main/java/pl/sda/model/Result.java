
package pl.sda.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Result {

    @SerializedName("drawDate")
    @Expose
    private LocalDateTime drawDate;
    @SerializedName("drawSystemId")
    @Expose
    private int drawSystemId;
    @SerializedName("gameType")
    @Expose
    private String gameType;
    @SerializedName("resultsJson")
    @Expose
    private List<Integer> resultsJson = new ArrayList<Integer>();
    @SerializedName("specialResults")
    @Expose
    private List<Object> specialResults = new ArrayList<Object>();

    public LocalDateTime getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(LocalDateTime drawDate) {
        this.drawDate = drawDate;
    }

    public int getDrawSystemId() {
        return drawSystemId;
    }

    public void setDrawSystemId(int drawSystemId) {
        this.drawSystemId = drawSystemId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public List<Integer> getResultsJson() {
        return resultsJson;
    }

    public void setResultsJson(List<Integer> resultsJson) {
        this.resultsJson = resultsJson;
    }

    public List<Object> getSpecialResults() {
        return specialResults;
    }

    public void setSpecialResults(List<Object> specialResults) {
        this.specialResults = specialResults;
    }

}
