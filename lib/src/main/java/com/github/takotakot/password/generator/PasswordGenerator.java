package com.github.takotakot.password.generator;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PasswordGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateAlphanumeric(long count) {
        if (count < 0) {
            return "";
        }
        if (count <= 3) {
            return characterStreamToString(SecureRandomCharacterStream.randomAlphabetic(count));
        }
        List<Character> chars = Stream
                .of(SecureRandomCharacterStream.randomAlphanumeric(count - 3),
                        SecureRandomCharacterStream.randomUppercase(1),
                        SecureRandomCharacterStream.randomLowercase(1),
                        SecureRandomCharacterStream.randomNumeric(1))
                .reduce(Stream::concat).orElseGet(Stream::empty)
                .collect(Collectors.toList());
        return shuffledString(chars);
    }

    public static String generateAlphabetic(long count) {
        if (count < 0) {
            return "";
        }
        if (count <= 2) {
            return characterStreamToString(SecureRandomCharacterStream.randomAlphabetic(count));
        }
        List<Character> chars = Stream.of(SecureRandomCharacterStream.randomAlphabetic(count - 2),
                SecureRandomCharacterStream.randomUppercase(1),
                SecureRandomCharacterStream.randomLowercase(1))
                .reduce(Stream::concat).orElseGet(Stream::empty)
                .collect(Collectors.toList());
        return shuffledString(chars);
    }

    public static String generateCustom(long count, Collection<char[]> charSets) {
        if (count < 0) {
            return "";
        }
        char[] allChars = charSets.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString().toCharArray();
        if (count <= charSets.size()) {
            return characterStreamToString(SecureRandomCharacterStream.randomFromChars(count, allChars));
        }
        List<Character> chars = Stream
                .concat(SecureRandomCharacterStream.randomFromChars(count - charSets.size(),
                        allChars),
                        charSets.stream()
                                .map(charSet -> SecureRandomCharacterStream.randomFromChars(1,
                                        charSet))
                                .reduce(Stream::concat).orElseGet(Stream::empty))
                .collect(Collectors.toList());
        return shuffledString(chars);
    }

    private static String characterStreamToString(Stream<Character> stream) {
        return stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static String shuffledString(List<Character> chars) {
        Collections.shuffle(chars, secureRandom);
        return chars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

}
