package doubleplay.playbaseball.api;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ApiResultCode {
    SUCCESS("SUCCESS"),
    FAIL("FAIL");

    private final String label;

    private ApiResultCode(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return this.label;
    }
}
