package com.example.demo;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;


public class PlayerFilterTest{

    @Test
    void getAllPlayersTest(){
        List<Player> list = PlayerFilter.getAllPlayers();
        assert list.size() == 18207;
    }

    @Test
    void PlayersOlderThan34(){
        Flux<Player> olderThan34Players = PlayerFilter.PlayersOlderThan34();
    }

    @Test
    void OneClubPlayers(){
        Flux<Player> OnlyThisCLubPlayers = PlayerFilter.OneClubPlayers("Juventus");
    }

    @Test
    void getRanking(){
        Flux<List<Player>> listFlux = PlayerFilter.getRanking();
    }



}
