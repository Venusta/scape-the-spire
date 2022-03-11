package scapeTheSpire.cards.attack;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scapeTheSpire.cards.AbstractEasyCard;
import scapeTheSpire.util.SoundEffects;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.addToBottom;
import static scapeTheSpire.util.Wiz.sfxAction;;

public class Dharoks extends AbstractEasyCard {

  public final static String ID = makeID(Dharoks.class.getSimpleName());

  private static final int DAMAGE_PERCENT = 25;
  private static final int UPGRADE_PLUS_DAMAGE_PERCENT = 25;

  private static final int DEFAULT_DAMAGE = 0;

  public Dharoks() {
    super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
    damage = baseDamage = DAMAGE_PERCENT;
    magicNumber = baseMagicNumber = DEFAULT_DAMAGE;
  }

  @Override
  public void triggerWhenDrawn() {
    super.triggerWhenDrawn();
    magicNumber = MathUtils.floor((AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth)*damage/100f) + 3;
    isMagicNumberModified = magicNumber != baseMagicNumber;
  }

  @Override
  public void tookDamage() {
    magicNumber = MathUtils.floor((AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth)*damage/100f) + 3;
    isMagicNumberModified = magicNumber != baseMagicNumber;
  }

  @Override
  public void upgradeCard() {
    upgradeDamage(UPGRADE_PLUS_DAMAGE_PERCENT);
    initializeDescription();
  }

  @Override
  public void calculateCardDamage(AbstractMonster mo) {
    super.calculateCardDamage(mo);
    magicNumber = MathUtils.floor((AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth)*damage/100f) + 3;
    isMagicNumberModified = magicNumber != baseMagicNumber;
  }

  @Override
  public void use(AbstractPlayer player, AbstractMonster monster) {
    sfxAction(SoundEffects.dharok_axe_crush.getKey());

    calculateCardDamage(monster);
    addToBottom(new DamageAction(monster, new DamageInfo(player, magicNumber, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HEAVY));
  }

}
