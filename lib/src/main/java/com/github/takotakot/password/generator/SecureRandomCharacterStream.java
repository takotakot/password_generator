package com.github.takotakot.password.generator;

import java.security.SecureRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecureRandomCharacterStream {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static final char[] LOWERCASE_LETTERS = IntStream.rangeClosed('a', 'z')
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString().toCharArray();

    public static final char[] UPPERCASE_LETTERS = IntStream.rangeClosed('A', 'Z')
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString().toCharArray();

    public static final char[] NUMERIC_LETTERS = IntStream.rangeClosed('0', '9')
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString().toCharArray();

    public static final char[] ALPHABETIC_LETTERS = IntStream
            .concat(IntStream.rangeClosed('a', 'z'), IntStream.rangeClosed('A', 'Z'))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString().toCharArray();

    public static final char[] ALPHANUMERIC_LETTERS = IntStream
            .concat(IntStream.concat(IntStream.rangeClosed('a', 'z'),
                    IntStream.rangeClosed('A', 'Z')), IntStream.rangeClosed('0', '9'))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString().toCharArray();

    public static Stream<Character> randomFromChars(long count, char[] chars) {
        return secureRandom.ints(count, 0, chars.length).mapToObj(r -> chars[r]);
    }

    public static Stream<Character> randomLowercase(long count) {
        return randomFromChars(count, LOWERCASE_LETTERS);
    }

    public static Stream<Character> randomUppercase(long count) {
        return randomFromChars(count, UPPERCASE_LETTERS);
    }

    public static Stream<Character> randomNumeric(long count) {
        return randomFromChars(count, NUMERIC_LETTERS);
    }

    public static Stream<Character> randomAlphabetic(long count) {
        return randomFromChars(count, ALPHABETIC_LETTERS);
    }

    public static Stream<Character> randomAlphanumeric(long count) {
        return randomFromChars(count, ALPHANUMERIC_LETTERS);
    }

}
