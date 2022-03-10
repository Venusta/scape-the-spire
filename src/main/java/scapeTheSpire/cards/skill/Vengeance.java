package scapeTheSpire.cards.skill;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FlameBarrierPower;
import com.megacrit.cardcrawl.vfx.combat.FlameBarrierEffect;

import scapeTheSpire.cards.AbstractEasyCard;
import scapeTheSpire.util.SoundEffects;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.sfxAction;
import static scapeTheSpire.util.Wiz.vfxAction;
import static scapeTheSpire.util.Wiz.applyPowerToSelf;

public class Vengeance extends AbstractEasyCard {

  public final static String ID = makeID(Vengeance.class.getSimpleName());

  public Vengeance() {
    super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
    block = baseBlock = 12;
    magicNumber = baseMagicNumber = 4;
  }

  @Override
  public void upgradeCard() {
    upgradeBlock(4);
    upgradeMagicNumber(6);
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    sfxAction(SoundEffects.Vengeance.getKey());

    if (Settings.FAST_MODE) {
      vfxAction(new FlameBarrierEffect(p.hb.cX, p.hb.cY), 0.1F);
    } else {
      vfxAction(new FlameBarrierEffect(p.hb.cX, p.hb.cY), 0.5F);
    }

    block();
    applyPowerToSelf(new FlameBarrierPower(p, magicNumber));

  }

}
