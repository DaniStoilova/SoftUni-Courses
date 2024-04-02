package DefiningClassesExercises.Google.Google;

public class Parents {
    private String parentName;
    private String birthday;

    public Parents(String parentName, String birthday) {
        this.parentName = parentName;
        this.birthday = birthday;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String format(){
        return String.format("%s %s",parentName,birthday);
    }
}
