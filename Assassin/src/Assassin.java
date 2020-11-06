public interface Assassin {
void printKillRing();
void printGraveyard();
boolean killRingContains(String name);
boolean graveyardContains(String name);
boolean gameOver();
String winner();
void kill(String name);
}
