package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerWrapper {

    @XmlElement(name="player")
    List<PlayerImport> players;

    public List<PlayerImport> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerImport> players) {
        this.players = players;
    }
}
