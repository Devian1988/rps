package com.devsoft.rps;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Player {
    @EqualsAndHashCode.Include
    UUID id = UUID.randomUUID();

    String name;
    @Setter(value = AccessLevel.PROTECTED)
    PlayMove[] allowedMoves;

    public Player(String name,
                  PlayMove... allowedMoves) {
        this.name = name;
        this.allowedMoves = allowedMoves;
    }

    public PlayMove getMove() {
        int moveIndex = ThreadLocalRandom.current().nextInt(0, allowedMoves.length);
        return allowedMoves[moveIndex];
    }

}
