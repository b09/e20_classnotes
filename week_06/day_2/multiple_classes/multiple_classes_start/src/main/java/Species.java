public enum Species {
    BEAR(1000, Endangered.LEAST_CONMCERN),
    CROCODILE(500, Endangered.ENDAGERED),
    HERON(250, Endangered.THREATENED),
    WOLF(750, Endangered.EXTINCT),
    CHEETAH(2, Endangered.ENDAGERED);


    int countAlive;
    Endangered riskStatus;

    Species(int countAlive, Endangered riskStatus) {
        this.countAlive = countAlive;
        this.riskStatus = riskStatus;
    }

    public String getColor(){
        return this.riskStatus.getColor();
    }
}
