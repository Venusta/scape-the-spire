package scapeTheSpire.cards.skill;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;
import com.megacrit.cardcrawl.vfx.combat.FlameBarrierEffect;

import scapeTheSpire.cards.AbstractEasyCard;
import scapeTheSpire.util.SoundEffects;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.sfxAction;
import static scapeTheSpire.util.Wiz.vfxAction;
import static scapeTheSpire.util.Wiz.applyPowerToSelf;

public class SuperStrength extends AbstractEasyCard {

  public final static String ID = makeID(SuperStrength.class.getSimpleName());

  public SuperStrength() {
    super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
    baseMagicNumber = magicNumber = 5;

  }

  @Override
  public void upgradeCard() {
    upgradeMagicNumber(3);

  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    sfxAction(SoundEffects.Liquid.getKey());

    if (Settings.FAST_MODE) {
      vfxAction(new FlameBarrierEffect(p.hb.cX, p.hb.cY), 0.1F);
    } else {
      vfxAction(new FlameBarrierEffect(p.hb.cX, p.hb.cY), 0.5F);
    }
    applyPowerToSelf(new VigorPower(p, this.magicNumber));

  }

}
