package pl.sda.input;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pl.sda.model.GameType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class DefaultTypeProviderTest {

    @Mock
    MyScanner scanner;


    @Before
    public void setUp() throws Exception {
        openMocks(this);
    }

    @Test
    public void by_default_provider_should_return_lotto_game_type() {
//        when(scanner.nextLine()).thenReturn("");
//        when(scanner.nextLine()).thenReturn(null);
        when(scanner.nextLine()).thenReturn("blednyTekst");

        GameTypeProvider sut = new DefaultTypeProvider(scanner);

        GameType result = sut.getGameType();

        assertEquals(GameType.LOTTO, result);
    }

    @Test
    public void should_return_type_ignoring_case_sensitive() {
        when(scanner.nextLine()).thenReturn("loTtO");

        GameTypeProvider sut = new DefaultTypeProvider(scanner);

        GameType result = sut.getGameType();

        assertEquals(GameType.LOTTO, result);
    }

    @Test
    public void should_return_type_with_white_characters() {
        when(scanner.nextLine()).thenReturn("\nszybkie600");

        GameTypeProvider sut = new DefaultTypeProvider(scanner);

        GameType result = sut.getGameType();

        assertEquals(GameType.SZYBKIE_600, result);
    }

    @Test
    public void should_return_type_SZYBKIE_600() {
        when(scanner.nextLine()).thenReturn("szybkie600");

        GameTypeProvider sut = new DefaultTypeProvider(scanner);

        GameType result = sut.getGameType();

        assertEquals(GameType.SZYBKIE_600, result);
    }

    @Test
    public void should_return_type_MINI_LOTTO() {
        when(scanner.nextLine()).thenReturn("minilotto");

        GameTypeProvider sut = new DefaultTypeProvider(scanner);

        GameType result = sut.getGameType();

        assertEquals(GameType.MINI_LOTTO, result);
    }

    @Test
    public void should_return_type_LOTTO() {
        when(scanner.nextLine()).thenReturn("lotto");

        GameTypeProvider sut = new DefaultTypeProvider(scanner);

        GameType result = sut.getGameType();

        assertEquals(GameType.LOTTO, result);
    }

    @Test
    public void should_return_type_KASKADA() {
        when(scanner.nextLine()).thenReturn("kaskada");

        GameTypeProvider sut = new DefaultTypeProvider(scanner);

        GameType result = sut.getGameType();

        assertEquals(GameType.KASKADA, result);
    }
}