package scapeTheSpire.cards.attack;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.SweepingBeamEffect;

import scapeTheSpire.cards.AbstractEasyCard;
import scapeTheSpire.util.SoundEffects;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.sfxAction;
import static scapeTheSpire.util.Wiz.vfxAction;
import static scapeTheSpire.util.Wiz.forAllMonstersLiving;
import static scapeTheSpire.util.Wiz.addToBottom;;

public class IceBarrage extends AbstractEasyCard {

  public final static String ID = makeID(IceBarrage.class.getSimpleName());

  public IceBarrage() {
    super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY);
    baseDamage = 12;
    isMultiDamage = true;
    this.exhaust = true;
  }

  @Override
  public void upgradeCard() {
    upgradeDamage(5);
    upgradeBaseCost(2);
  }

  @Override
  public void use(AbstractPlayer player, AbstractMonster m) {
    sfxAction(SoundEffects.IceBarrageSfx.getKey());
    vfxAction(new SweepingBeamEffect(AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY,
        AbstractDungeon.player.flipHorizontal), 0.4F);
    damageAll(AbstractGameAction.AttackEffect.LIGHTNING);

    forAllMonstersLiving(
        (monster) -> addToBottom(new StunMonsterAction(monster, player, 1)));
  }

}
