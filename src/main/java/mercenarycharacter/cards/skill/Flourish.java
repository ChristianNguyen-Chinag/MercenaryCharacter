package mercenarycharacter.cards.skill;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;
import mercenarycharacter.cards.BaseCard;
import mercenarycharacter.character.MercenaryCharacter;
import mercenarycharacter.util.CardStats;

public class Flourish extends BaseCard {

    private static final int VIGOR = 4;
    private static final int UPG_VIGOR = 3;

    public static final String ID = makeID(Flourish.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MercenaryCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    );

    public  Flourish() {
        super(ID,info);
        setMagic(VIGOR, UPG_VIGOR);
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new VigorPower(p, magicNumber), magicNumber,AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }
}
