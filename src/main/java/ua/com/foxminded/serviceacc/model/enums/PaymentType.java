package ua.com.foxminded.serviceacc.model.enums;

public enum PaymentType {

    CASH("Наличный расчет"), BANK("Перевод на расчетный счет"), WESTERN_UNION("Перевод Western Union"), UNISTREAM(
            "Перевод Unistream"), OTHER("Другое");

    private String friendlyName;

    private PaymentType(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

}
