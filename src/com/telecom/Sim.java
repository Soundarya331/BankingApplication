package com.telecom;

public class Sim {

    private int simId;
    private boolean kycCompleted;
    private boolean activated;

    public Sim(int simId) {
        this.simId = simId;
    }

    public int getSimId() { return simId; }
    public boolean isKycCompleted() { return kycCompleted; }
    public void setKycCompleted(boolean kycCompleted) { this.kycCompleted = kycCompleted; }
    public boolean isActivated() { return activated; }
    public void setActivated(boolean activated) { this.activated = activated; }
}
