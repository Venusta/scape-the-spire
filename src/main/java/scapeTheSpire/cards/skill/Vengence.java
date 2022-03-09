package scapeTheSpire.cards.skill;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FlameBarrierPower;
import com.megacrit.cardcrawl.vfx.combat.FlameBarrierEffect;
import com.megacrit.cardcrawl.vfx.combat.SweepingBeamEffect;

import scapeTheSpire.cards.AbstractEasyCard;
import scapeTheSpire.util.SoundEffects;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.sfxAction;
import static scapeTheSpire.util.Wiz.vfxAction;
import static scapeTheSpire.util.Wiz.applyPowerToSelf;

public class Vengence extends AbstractEasyCard {

  public final static String ID = makeID(Vengence.class.getSimpleName());

  public Vengence() {
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
    sfxAction(SoundEffects.VengenceSfx.getKey());

    if (Settings.FAST_MODE) {
      vfxAction(new FlameBarrierEffect(p.hb.cX, p.hb.cY), 0.1F);
    } else {
      vfxAction(new FlameBarrierEffect(p.hb.cX, p.hb.cY), 0.5F);
    }

    block();
    applyPowerToSelf(new FlameBarrierPower(p, magicNumber));

  }

}
