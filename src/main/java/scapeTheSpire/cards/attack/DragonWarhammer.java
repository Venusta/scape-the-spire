package scapeTheSpire.cards.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import scapeTheSpire.cards.AbstractEasyCard;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.applyVulnToEnemy;

public class DragonWarhammer extends AbstractEasyCard {

  public final static String ID = makeID(DragonWarhammer.class.getSimpleName());

  public DragonWarhammer() {
    super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
    baseDamage = 20;
    magicNumber = baseMagicNumber = 2;
  }

  @Override
  public void upgradeCard() {
    upgradeDamage(10);
    upgradeMagicNumber(3);
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    damage(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
    applyVulnToEnemy(m, magicNumber);
  }

}
