package spatula.test.junit.factory;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public final class TestUtils {

    /**
     * Конструктор.
     *
     */
    private TestUtils() {
    }

    private static int counter = 0;

    private static Random r = new Random();

    /**
     * Получить дату без времени.
     *
     * @return дата
     */
    public static Date getDateNoTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * Получить число в виде строки с заданным количеством цифр.
     *
     * @param length количество цифр
     * @return число в виде строки
     */
    protected static String getRandomDigitsString(int length) {
        StringBuilder res = new StringBuilder();
        while (res.length() < length) {
            res.append(r.nextInt());
        }
        res.setLength(length);
        return res.toString();
    }

    /**
     * Получаем следующее значение счетчика в диапазоне 0-999999
     * @return следующее значение счетчика
     */
    public static int getCounter() {
        synchronized (TestUtils.class) {
            return ++counter % 1000000;
        }
    }

    /**
     * Получение счётчика в виде объектного типа Integer.
     *
     * @return счётчик в виде Integer
     */
    public static Integer getCounterInteger() {
        return getCounter();

    }

    /**
     * Получение счётчика в виде строки.
     *
     * @return счётчик в виде строки
     */
    public static String getCounterString() {
        return getCounterInteger().toString();
    }
}
