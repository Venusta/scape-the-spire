package scapeTheSpire.util;

import basemod.Pair;

import static scapeTheSpire.ScapeTheSpire.makeID;

import java.util.HashMap;

import static scapeTheSpire.ScapeTheSpire.makeAudioPath;

public class SoundEffects {
  private static final HashMap<String, String> hashMap = new HashMap<String, String>();

  public static Pair<String, String> makePair(String name) {
    String key = makeID(name + "Sfx");
    String value = makeAudioPath(name + ".mp3");
    hashMap.put(key, value);

    return new Pair<String, String>(key, value);
  }

  public static final Pair<String, String> Vengeance = makePair("Vengeance");
  public static final Pair<String, String> IceBarrage = makePair("IceBarrage");

  public static HashMap<String, String> getHashMap() {
    return hashMap;
  }
}
