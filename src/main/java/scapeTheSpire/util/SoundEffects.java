package scapeTheSpire.util;

import basemod.Pair;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.ScapeTheSpire.makeAudioPath;

public class SoundEffects {
  public static final Pair<String, String> IceBarrageSfx = new Pair<>(makeID("IceBarrageSfx"), makeAudioPath("IceBarrage.mp3"));
  public static final Pair<String, String> VengenceSfx = new Pair<>(makeID("VengenceSfx"), makeAudioPath("Vengence.mp3"));
}
