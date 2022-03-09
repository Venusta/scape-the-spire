package scapeTheSpire.util;

import basemod.Pair;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.ScapeTheSpire.makeAudioPath;

public class SoundEffects {

  public static Pair<String, String> makePair(String name) {
    return new Pair<String, String>(makeID(name + "Sfx"), makeAudioPath(name + ".mp3"));
  }

  // method name must match "name + sfx"
  public static final Pair<String, String> VengenceSfx = makePair("Vengence");
  public static final Pair<String, String> IceBarrageSfx = makePair("IceBarrage");
}
