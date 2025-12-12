import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SystemDateProvider implements DateProvider {
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Override
    public String todayAsString() {
        return LocalDate.now().format(FORMATTER);
    }
}

