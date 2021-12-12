package com.example.demo;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.*;


public class PlayerFilterTest{

    @Test
    void getAllPlayersTest(){
        List<Player> list = PlayerFilter.getAllPlayers();
        assert list.size() == 18207;
    }

    @Test
    void PlayersOlderThan34(){
        Flux<Player> listFlux = PlayerFilter.PlayersOlderThan34();
    }

    @Test
    void OneClubPlayers(){
        Flux<Player> listFlux = PlayerFilter.OneClubPlayers("Juventus");
    }

    @Test
    void getRanking(){
        Flux<Player> listFlux = PlayerFilter.getRanking("Argentina");
    }



}
