package ua.com.foxminded.serviceacc.model.enums;

public enum ContractStatus {
    PENDING("В ожидании"),
    ACTIVE("Активный"),
    FROZEN("Замороженный"),
    CLOSED("Закрытый");
    
    private ContractStatus(String friendlyName) {
        this.friendlyName = friendlyName;
    }
    
    private String friendlyName;
    
    public String getFriendlyName () {
        return friendlyName;
    }

}
