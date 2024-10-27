package doubleplay.playbaseball.code;

public class SystemCode {

    /**
     * 일반 에러 메시지
     * ERROR -> CE
     * MESSAGE -> CM
     *
     */
    public enum COMMON_MESSAGE implements LabelEnum {
        // 일반 에러
        NULL("CE0000", "존재하지 않는 대상 참조"),
        DUPLICATE("CE0001", "동일한 값 또는 이름이 존재합니다."),
        VERIFICATION("CE0002", "잘못된 데이터를 입력하셨습니다."),
        REQUIRED_DATA_MISSING("CE0003", "필수 값이 누락되었습니다."),
        NOT_CERTIFICATED("CE0004", "인증되지 않은 요청입니다."),
        FILE_IO("CE0003", "파일 입출력 에러"),
        HAS_RELATION("CE0004", "연관된 데이터가 존재합니다."),
        HAS_CHILDREN("CE0005", "하위 데이터가 존재합니다."),
        WRONG_FILE_TYPE("CE0006", "업로드 불가능한 파일형식입니다."),
        DELETED("CE0007", "삭제된 항목입니다.."),
        NO_PERMISSION_CATEGORY("CE0008", "카테고리 조회 권한이 없습니다."),
        NO_PERMISSION("CE0009", "권한이 없습니다."),
        DATA_GENERATION_ERROR("CE0010", "통계 데이터 생성중 오류 발생"),

        // 일반 메시지
        SUCCESS("CM0000", "요청하신 작업 처리가 완료되었습니다.")
        ;

        private final String code;
        private final String label;

        COMMON_MESSAGE(String code, String label) {
            this.code = code;
            this.label = label;
        }

        public static String findLabelByCode(final String code) {
            return switch (code) {
                case "CE0000" -> NULL.getLabel();
                case "CE0001" -> DUPLICATE.getLabel();
                case "CE0004" -> NOT_CERTIFICATED.getLabel();
                case "CM0000" -> SUCCESS.getLabel();
                default -> "";
            };
        }

        @Override
        public String getCode() {
            return this.code;
        }

        @Override
        public String getLabel() {
            return this.label;
        }
    }
}
