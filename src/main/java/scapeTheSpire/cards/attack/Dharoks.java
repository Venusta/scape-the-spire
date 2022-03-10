package scapeTheSpire.cards.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scapeTheSpire.cards.AbstractEasyCard;

import static scapeTheSpire.ScapeTheSpire.makeID;

public class Dharoks extends AbstractEasyCard {

  public final static String ID = makeID(Dharoks.class.getSimpleName());

  public Dharoks() {
    super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
    baseDamage = 1;
    isDamageModified = true;
    magicNumber = baseMagicNumber = 0;
  }

  @Override
  public void upgradeCard() {
    upgradeDamage(3);
  }

  @Override
  public void tookDamage() {
    this.baseDamage = AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth;
    rawDescription = cardStrings.DESCRIPTION;
    initializeDescription();
  }

  @Override
  public void triggerWhenDrawn() {
    this.baseDamage = AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth;
    rawDescription = cardStrings.DESCRIPTION;
    initializeDescription();
  }

  @Override
  public void use(AbstractPlayer player, AbstractMonster monster) {
    this.baseDamage = player.maxHealth - player.currentHealth;
    calculateCardDamage(monster);
    damage(monster, AbstractGameAction.AttackEffect.SLASH_HEAVY);
    rawDescription = cardStrings.DESCRIPTION;
    initializeDescription();

  }

}
