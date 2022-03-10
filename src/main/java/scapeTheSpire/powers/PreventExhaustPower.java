package scapeTheSpire.powers;

import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

import static scapeTheSpire.ScapeTheSpire.makeID;

public class PreventExhaustPower extends AbstractEasyPower {
  public final static String ID = makeID(PreventExhaustPower.class.getSimpleName());
  private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);
  public static final String NAME = powerStrings.NAME;
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
  public static final int CAP = 70;

  public PreventExhaustPower(final AbstractCreature owner, final int amount) {
    super(NAME, PowerType.BUFF, false, owner, amount);
    name = NAME;
    updateDescription();
  }

  @Override
  public void onAfterUseCard(final AbstractCard card, final UseCardAction action) {
    int random = AbstractDungeon.cardRandomRng.random(100 - 1); // -1 cause the game adds +1
    if (random < amount) {
      action.exhaustCard = false;
    }
  }

  @Override
  public void stackPower(int stackAmount) {
    this.amount += stackAmount;
    if (this.amount >= CAP) {
      this.amount = CAP;
    }
  }

  @Override
  public void updateDescription() {
    description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
  }

}
