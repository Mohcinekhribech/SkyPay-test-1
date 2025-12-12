public class FakeDateProvider implements DateProvider {
    private String date;

    public void setDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        this.date = date;
    }

    @Override
    public String todayAsString() {
        if (date == null) {
            throw new IllegalStateException("Date must be set using setDate() before calling todayAsString()");
        }
        return date;
    }
}

