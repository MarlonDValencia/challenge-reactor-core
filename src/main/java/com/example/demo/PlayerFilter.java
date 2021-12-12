package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class PlayerFilter {
    public static List<Player> getAllPlayers() {
        ;
        return CsvUtilFile.getPlayers();
    }

    public static Flux<Player> PlayersOlderThan34() {
        List<Player> list = CsvUtilFile.getPlayers();
        Flux<Player> PlayerFlux = Mono.just(list).flatMapMany(Flux::fromIterable);
        return PlayerFlux.
                buffer(100)
                .flatMap(jugador -> Flux.fromStream(jugador.parallelStream()))
                .filter(jugador -> jugador.getAge() > 34)
                .switchIfEmpty(Mono.error(new RuntimeException("No hay jugadores con 34 años")));
    }

    public static Flux<Player> OneClubPlayers(String club) {
        List<Player> list = CsvUtilFile.getPlayers();
        Flux<Player> PlayerFlux = Mono.just(list).flatMapMany(Flux::fromIterable);
        return PlayerFlux.
                buffer(100)
                .flatMap(jugador -> Flux.fromStream(jugador.parallelStream()))
                .filter(jugador -> jugador.getClub().equals(club))
                .switchIfEmpty(Mono.error(new RuntimeException("No hay jugadores de dicho club")));
    }

    public static Flux<Player> getRanking(String nation) {
        List<Player> list = CsvUtilFile.getPlayers();
        Flux<Player> PlayerFlux = Mono.just(list).flatMapMany(Flux::fromIterable);
        var filtro = PlayerFlux.
                buffer(100)
                .flatMap(jugador -> Flux.fromStream(jugador.parallelStream()))
                .filter(jugador -> jugador.getNational().equals(nation))
                .switchIfEmpty(Mono.error(new RuntimeException("No hay jugadores con dicha nacionalidad")))
                .collectSortedList();
        return PlayerFlux;
                //Flux.fromIterable (Arrays.asList(filtro)).sort( (obj1, obj2) -> obj1.getName().compareTo(obj2.getName()));


    }
}
