package mercenarycharacter.cards.skill;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mercenarycharacter.cards.BaseCard;
import mercenarycharacter.character.MercenaryCharacter;
import mercenarycharacter.powers.MomentumPower;
import mercenarycharacter.util.CardStats;

public class ChargeAhead extends BaseCard {
    private static final int MOMENTUM = 3;

    public static final String ID = makeID(ChargeAhead.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MercenaryCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            0
    );

    public  ChargeAhead() {
        super(ID,info);
        setMagic(MOMENTUM);
        setExhaust(true, false);
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new MomentumPower(p, magicNumber)));
    }
}
