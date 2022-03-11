package scapeTheSpire.cards.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

import scapeTheSpire.cards.AbstractEasyCard;
import scapeTheSpire.util.SoundEffects;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.applyPowerToEnemy;
import static scapeTheSpire.util.Wiz.sfxAction;

public class DragonDagger extends AbstractEasyCard {

  public final static String ID = makeID(DragonDagger.class.getSimpleName());

  public DragonDagger() {
    this(0);
  }

  public DragonDagger(int upgrades) {
    super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
    baseDamage = 4;
    baseMagicNumber = magicNumber = 3;
    timesUpgraded = upgrades;
  }

  @Override
  public void upgradeCard() {
    this.timesUpgraded += 1;
    if (this.timesUpgraded == 1) {
      upgradeMagicNumber(2);
      this.name = cardStrings.NAME.replace("(p)", "(p+)");
    }
    if (this.timesUpgraded == 2) {
      upgradeMagicNumber(3);
      upgradeBaseCost(1);
      this.name = cardStrings.NAME.replace("(p)", "(p++)");
    }
    initializeTitle();
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    sfxAction(SoundEffects.puncture.getKey());

    damage(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    applyPowerToEnemy(m, new PoisonPower(m, p, magicNumber));
    damage(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);
    applyPowerToEnemy(m, new PoisonPower(m, p, magicNumber));

  }

  @Override
  public boolean canUpgrade() {
    return this.timesUpgraded < 2;
  }

  // public AbstractCard makeCopy() {
  // return new SearingBlow(this.timesUpgraded);
  // }
  @Override
  public AbstractCard makeCopy() {
    return new DragonDagger(this.timesUpgraded);
  }

}
