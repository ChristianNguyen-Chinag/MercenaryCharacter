package mercenarycharacter.cards.skill;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mercenarycharacter.cards.BaseCard;
import mercenarycharacter.character.MercenaryCharacter;
import mercenarycharacter.util.CardStats;

public class QuickLunch extends BaseCard {

    private static final int TEMPHP = 4;
    private static final int UPG_TEMPHP = 3;

    private static final String ID = makeID(QuickLunch.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MercenaryCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    public QuickLunch(){
        super(ID, info);
        setExhaust(true);
        setMagic(TEMPHP, UPG_TEMPHP);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new AddTemporaryHPAction(p, p, magicNumber));
    }
}
