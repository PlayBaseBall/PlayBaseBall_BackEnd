package doubleplay.playbaseball.entities.user;

public enum PROVIDER implements ProviderEnum {
    KAKAOTALK("카카오톡", "KAKAOTALK"),
    FACEBOOK("페이스북", "FACEBOOK"),
    GOOGLE("구글", "GOOGLE"),
    NAVER("네이버", "NAVER");
    private String korName;
    private String engName;

    PROVIDER(String korName, String engName) {
        this.korName = korName;
        this.engName = engName;
    }

    @Override
    public String getKorName() {
        return this.korName;
    }

    @Override
    public String getEngName() {
        return this.engName;
    }
}
