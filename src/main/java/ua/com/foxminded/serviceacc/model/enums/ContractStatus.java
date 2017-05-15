package ua.com.foxminded.serviceacc.model.enums;

public enum ContractStatus {

    ACTIVE("Активирован"), FROZEN("Заморожен"), CLOSED("Завершен");

    private ContractStatus(String localizedName) {
        this.localizedName = localizedName;
    }

    private String localizedName;

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

}
