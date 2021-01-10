
package pl.sda.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("drawSystemId")
    @Expose
    private int drawSystemId;
    @SerializedName("drawDate")
    @Expose
    private LocalDateTime drawDate;
    @SerializedName("gameType")
    @Expose
    private GameType gameType;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();
    @SerializedName("showSpecialResults")
    @Expose
    private boolean showSpecialResults;

    public int getDrawSystemId() {
        return drawSystemId;
    }

    public void setDrawSystemId(int drawSystemId) {
        this.drawSystemId = drawSystemId;
    }

    public LocalDateTime getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(LocalDateTime drawDate) {
        this.drawDate = drawDate;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public boolean isShowSpecialResults() {
        return showSpecialResults;
    }

    public void setShowSpecialResults(boolean showSpecialResults) {
        this.showSpecialResults = showSpecialResults;
    }

}
