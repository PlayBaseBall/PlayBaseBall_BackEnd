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
        ERROR_NULL_REFERENCE("CE0000", "존재하지 않는 대상 참조"),
        ERROR_DUPLICATE_VALUE("CE0001", "동일한 값 또는 이름이 존재합니다."),
        ERROR_INVALID_INPUT("CE0002", "잘못된 데이터를 입력하셨습니다."),
        ERROR_MISSING_REQUIRED_DATA("CE0003", "필수 값이 누락되었습니다."),
        ERROR_UNAUTHORIZED_REQUEST("CE0004", "인증되지 않은 요청입니다."),
        ERROR_FILE_IO("CE0005", "파일 입출력 에러"),
        ERROR_RELATED_DATA_EXISTS("CE0006", "연관된 데이터가 존재합니다."),
        ERROR_CHILD_DATA_EXISTS("CE0007", "하위 데이터가 존재합니다."),
        ERROR_UNSUPPORTED_FILE_TYPE("CE0008", "업로드 불가능한 파일 형식입니다."),
        ERROR_DELETED_ITEM("CE0009", "삭제된 항목입니다."),
        ERROR_NO_CATEGORY_PERMISSION("CE0010", "카테고리 조회 권한이 없습니다."),
        ERROR_NO_PERMISSION("CE0011", "권한이 없습니다."),
        ERROR_STATISTICS_GENERATION("CE0012", "통계 데이터 생성 중 오류 발생"),

        // 일반 메시지
        MSG_SUCCESS("CM0000", "요청하신 작업 처리가 완료되었습니다.");

        private final String code;
        private final String label;

        COMMON_MESSAGE(String code, String label) {
            this.code = code;
            this.label = label;
        }

        public static String findLabelByCode(final String code) {
            return switch (code) {
                case "CE0000" -> ERROR_NULL_REFERENCE.getLabel();
                case "CE0001" -> ERROR_DUPLICATE_VALUE.getLabel();
                case "CE0004" -> ERROR_UNAUTHORIZED_REQUEST.getLabel();
                case "CM0000" -> MSG_SUCCESS.getLabel();
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
