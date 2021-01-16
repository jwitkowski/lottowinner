package pl.sda.network;

import pl.sda.model.GameType;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PageProvider {
    private PageProvider() {

    }

    public static int getPage(GameType type, LocalDateTime date) {
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

    private static int getPageForLotto(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();
        int pageCounter = 0;

        while (now.isAfter(date) || now.isEqual(date)) {
            if (!(now.toLocalDate().isEqual(date.toLocalDate()) && now.getHour() > 21)) {
                now = now.minusDays(1);
            }

            if (now.getDayOfWeek() == DayOfWeek.TUESDAY || now.getDayOfWeek() == DayOfWeek.THURSDAY || now.getDayOfWeek() == DayOfWeek.SATURDAY) {
                pageCounter++;
            }
        }

        return pageCounter;
    }

    private static int getPageForMiniLotto(LocalDateTime date) {
        return (int) ChronoUnit.DAYS.between(date, LocalDateTime.now());
    }

    private static int getPageForKaskada(LocalDateTime date) {
        return (int) ChronoUnit.DAYS.between(date, LocalDateTime.now()) * 2;
    }
}
