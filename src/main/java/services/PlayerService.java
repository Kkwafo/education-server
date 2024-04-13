package services;

import model.Player;

public interface PlayerService {
    boolean registerPlayer(Player player);
    Player loginPlayer(Player player);
    String getPlayerProgress(Long id);
}
