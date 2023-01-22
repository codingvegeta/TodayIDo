package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Album extends Item {
    private String arist;
    private String etc;

    public String getArist() {
        return arist;
    }

    public void setArist(String arist) {
        this.arist = arist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
