package scapeTheSpire.cards.democards.complex;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import scapeTheSpire.actions.EasyXCostAction;
import scapeTheSpire.cards.AbstractEasyCard;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.applyToSelfTop;
import static scapeTheSpire.util.Wiz.addToBottom;

public class EasyXCostDemo extends AbstractEasyCard {
  public final static String ID = makeID("EasyXCostDemo");
  // intellij stuff attack, enemy, rare, , , , , 0, 1

  public EasyXCostDemo() {
    super(ID, -1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
    baseMagicNumber = magicNumber = 0;
    baseDamage = 5;
    exhaust = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBottom(new EasyXCostAction(this, (effect, params) -> {
      for (int i = 0; i < effect + params[0]; i++) {
        dmgTop(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
      }
      applyToSelfTop(new StrengthPower(p, effect + params[0]));
      return true;
    }, magicNumber));
  }

  public void upgradeCard() {
    upgradeMagicNumber(1);
    uDesc();
  }
}