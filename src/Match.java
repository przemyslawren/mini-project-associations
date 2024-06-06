import java.util.Date;

public class Match {
    private String id;
    private Date startDate;

    public Match(String id, Date startDate) {
        this.id = id;
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", date=" + startDate +
                '}';
    }
}
