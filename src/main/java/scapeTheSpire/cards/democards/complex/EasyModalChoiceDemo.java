package scapeTheSpire.cards.democards.complex;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import scapeTheSpire.actions.EasyModalChoiceAction;
import scapeTheSpire.cards.AbstractEasyCard;
import scapeTheSpire.cards.EasyModalChoiceCard;

import java.util.ArrayList;

import static scapeTheSpire.ScapeTheSpire.makeID;
import static scapeTheSpire.util.Wiz.*;

public class EasyModalChoiceDemo extends AbstractEasyCard {
  public final static String ID = makeID("EasyModalChoiceDemo");
  // intellij stuff skill, self, uncommon, , , , , ,

  public EasyModalChoiceDemo() {
    super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
    baseMagicNumber = magicNumber = 3;
    baseSecondMagic = secondMagic = 1;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    ArrayList<AbstractCard> easyCardList = new ArrayList<>();
    easyCardList.add(new EasyModalChoiceCard("Draw", "Draw " + magicNumber + " cards.", () -> att(new DrawCardAction(magicNumber))));
    easyCardList.add(new EasyModalChoiceCard("Strength", "Gain " + secondMagic + " Strength.", () -> applyToSelfTop(new StrengthPower(p, secondMagic))));
    addToBottom(new EasyModalChoiceAction(easyCardList));
  }

  public void upgradeCard() {
    upgradeMagicNumber(1);
    upgradeSecondMagic(1);
  }
}