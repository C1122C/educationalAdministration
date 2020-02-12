package po;

public class College {
    private Integer collegeId;

    private String collegeName;

    public College(){}

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeid) {
        this.collegeId = collegeid;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }
}