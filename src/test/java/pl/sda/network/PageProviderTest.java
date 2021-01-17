package pl.sda.network;

import org.junit.Before;
import org.junit.Test;
import pl.sda.model.GameType;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class PageProviderTest {
    private PageProvider sut;

    @Before
    public void setUp() throws Exception {
        sut = new PageProvider(LocalDateTime.of(2021, Month.JANUARY, 17, 0, 0));
    }

    @Test
    public void should_return_newest_page_if_date_is_from_future() {
        int result = sut.getPage(GameType.LOTTO, LocalDateTime.MAX);

        assertEquals(0, result);
    }

    @Test
    public void should_return_newest_page_if_date_is_before_1957() {
        int result = sut.getPage(GameType.LOTTO, LocalDateTime.MIN);

        assertEquals(-1, result);
    }

    @Test
    public void should_return_newest_page_if_searching_date_is_null() {
        int result = sut.getPage(GameType.LOTTO, null);

        assertEquals(0, result);
    }

    @Test
    public void should_return_proper_page() {
        int result = sut.getPage(GameType.LOTTO, LocalDateTime.of(2021, Month.JANUARY, 7, 0, 0));

        assertEquals(5, result);
    }

    @Test
    public void should_return_proper_page_if_draw_was_today_after() {
        PageProvider localSut = new PageProvider(LocalDateTime.of(2021, Month.JANUARY, 16, 22, 0));
        int result = localSut.getPage(GameType.LOTTO, LocalDateTime.of(2021, Month.JANUARY, 16, 0, 0));

        assertEquals(0, result);
    }

    @Test
    public void should_return_proper_page_if_draw_was_today_before() {
        PageProvider localSut = new PageProvider(LocalDateTime.of(2021, Month.JANUARY, 16, 18, 0));
        int result = localSut.getPage(GameType.LOTTO, LocalDateTime.of(2021, Month.JANUARY, 16, 0, 0));

        assertEquals(0, result);
    }
}