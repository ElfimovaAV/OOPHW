package seminar7.observer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Vacancy {
    ELECTRICIANS,
    DEVELOPER,
    TESTER,
    ACCOUNTANT,
    DIRECTOR,
    ANALYST;

    private static final List<Vacancy> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Vacancy randomVacancy()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}