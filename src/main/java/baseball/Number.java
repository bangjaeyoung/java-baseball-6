package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Number {
    private static final int NUMBERS_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    
    // 컴퓨터의 숫자를 설정하는 메서드
    public String setComputersNumber() {
        Set<Integer> digits = new LinkedHashSet<>();
        
        while (digits.size() < NUMBERS_LENGTH) {
            digits.add(getRandomNumber());
        }
        
        return convertIntegerSetToString(digits);
    }
    
    // 사용자의 숫자를 설정하는 메서드
    public String setUserNumber(String userInput) {
        if (!isValidNumber(userInput)) {
            throw new IllegalArgumentException();
        }
        
        return userInput;
    }
    
    // Randoms 클래스를 통해 난수를 가져오는 메서드
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
    
    // Integer 타입의 Set을 String 타입의 문자열로 변환하는 메서드
    private String convertIntegerSetToString(Set<Integer> digits) {
        StringBuilder result = new StringBuilder();
        
        for (Integer digit : digits) {
            result.append(digit);
        }
        
        return String.valueOf(result);
    }
    
    // 유효한 숫자인지 판별하는 메서드
    private boolean isValidNumber(String inputNumber) {
        return isRightLength(inputNumber, NUMBERS_LENGTH) &&
                areAllDigitsInSpecificRange(inputNumber, MIN_NUMBER, MAX_NUMBER) &&
                hasNoDuplicateDigits(inputNumber);
    }
    
    // 특정 길이가 맞는지 판별하는 메서드
    private boolean isRightLength(String inputNumber, int length) {
        return inputNumber.length() == length;
    }
    
    // 특정 범위 안에 있는 숫자로 구성되어 있는지 판별하는 메서드
    private boolean areAllDigitsInSpecificRange(String inputNumber, int minDigit, int maxDigit) {
        for (char currentDigit : inputNumber.toCharArray()) {
            int digitValue = Character.getNumericValue(currentDigit);
            if (digitValue < minDigit || digitValue > maxDigit) {
                return false;
            }
        }
        
        return true;
    }
    
    // 중복되는 숫자가 없는지 판별하는 메서드
    private boolean hasNoDuplicateDigits(String inputNumber) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : inputNumber.toCharArray()) {
            uniqueDigits.add(digit);
        }
        
        return inputNumber.length() == uniqueDigits.size();
    }
}
