package scapeTheSpire.cards.power;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scapeTheSpire.cards.AbstractEasyCard;
import scapeTheSpire.powers.PreventExhaustPower;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.applyPowerToSelf;

public class AvasAssembler extends AbstractEasyCard {

  public final static String ID = makeID(AvasAssembler.class.getSimpleName());

  public AvasAssembler() {
    super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
    magicNumber = baseMagicNumber = 20;
  }

  @Override
  public void upgradeCard() {
    upgradeBaseCost(2);
    upgradeMagicNumber(10);
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    applyPowerToSelf(new PreventExhaustPower(p, magicNumber));
  }

}
