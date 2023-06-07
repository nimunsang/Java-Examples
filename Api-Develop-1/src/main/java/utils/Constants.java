package utils;

public class Constants {
    public final static int NAME_LENGTH_MIN = 4;
    public final static int NAME_LENGTH_MAX = 20;
    public final static int NAME_LENGTH_APPROPRIATE = (NAME_LENGTH_MAX + NAME_LENGTH_MIN) / 2;
    public final static String NAME_LENGTH_ERROR_MESSAGE = String.format("이름의 길이는 %d이상 %d이하여야 합니다.", NAME_LENGTH_MIN, NAME_LENGTH_MAX);

    public final static String NAME_PATTERN ="^[0-9a-zA-Z]+$";
    public final static String NAME_PATTERN_ERROR_MESSAGE = "이름은 영어와 숫자로만 구성되어야 합니다.";

    public final static String EMAIL_PATTERN = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+.com$";
    public final static String EMAIL_PATTERN_ERROR_MESSAGE ="올바르지 않은 이메일 형식입니다.";
}
