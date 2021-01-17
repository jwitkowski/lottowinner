package pl.sda.network;

import pl.sda.model.GameType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class PageProvider {
    private static final LocalDate FIRST_DATE = LocalDate.of(1957, Month.JANUARY, 27);

    private final LocalDateTime now;

    public PageProvider(LocalDateTime now) {
        this.now = now;
    }


    public int getPage(GameType type, LocalDateTime date) {
        switch (type) {
            case LOTTO:
                return getPageForLotto(date);
            case MINI_LOTTO:
                return getPageForMiniLotto(date);
            case KASKADA:
                return getPageForKaskada(date);
            default:
                return 0;
        }
    }

    private int getPageForLotto(LocalDateTime date) {
        if (date == null) {
            return 0;
        }

        if (date.toLocalDate().isBefore(FIRST_DATE)) {
            return -1;
        }

        int pageCounter = 0;
        LocalDateTime checkDate = now;

        while (checkDate.isAfter(date) || checkDate.toLocalDate().isEqual(date.toLocalDate())) {
            boolean isTheSameDate = checkDate.toLocalDate().isEqual(date.toLocalDate());
            if (isTheSameDate && checkDate.getHour() > 21) {
                return 0;
            }

            checkDate = checkDate.minusDays(1);

            if (checkDate.getDayOfWeek() == DayOfWeek.TUESDAY || checkDate.getDayOfWeek() == DayOfWeek.THURSDAY || checkDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                pageCounter++;
            }
        }

        return pageCounter;
    }

    private int getPageForMiniLotto(LocalDateTime date) {
        return (int) ChronoUnit.DAYS.between(date, LocalDateTime.now());
    }

    private int getPageForKaskada(LocalDateTime date) {
        return (int) ChronoUnit.DAYS.between(date, LocalDateTime.now()) * 2;
    }
}
