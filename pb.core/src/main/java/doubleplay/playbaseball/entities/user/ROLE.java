package doubleplay.playbaseball.entities.user;

public enum ROLE implements RoleEnum {

    USER("유저","USER"),
    ADMIN("관리자","ADMIN"),
    ;
    private String role;
    private String text;

    ROLE(String role, String text) {
        this.role = role;
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public String getRole() {
        return this.role;
    }
}
