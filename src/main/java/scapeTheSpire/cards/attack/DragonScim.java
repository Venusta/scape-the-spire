package scapeTheSpire.cards.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveAllBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scapeTheSpire.cards.AbstractEasyCard;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.addToBottom;

public class DragonScim extends AbstractEasyCard {
  public final static String ID = makeID(DragonScim.class.getSimpleName());

  public DragonScim() {
    super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
    baseDamage = 10;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBottom(new RemoveAllBlockAction(m, p));
    damage(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
  }

  @Override
  public void upgradeCard() {
    upgradeDamage(5);
  }


}
