package scapeTheSpire.relics;

import scapeTheSpire.TheScaper;

import static scapeTheSpire.ScapeTheSpire.makeID;

public class TodoItem extends AbstractEasyRelic {
  public static final String ID = makeID("TodoItem");

  public TodoItem() {
    super(ID, RelicTier.STARTER, LandingSound.FLAT, TheScaper.Enums.SCAPER_COLOR);
  }
}
