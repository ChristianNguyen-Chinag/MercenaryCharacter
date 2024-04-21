package mercenarycharacter.cards.skill;


import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mercenarycharacter.cards.BaseCard;
import mercenarycharacter.character.MercenaryCharacter;
import mercenarycharacter.util.CardStats;

public class Mettle extends BaseCard {

    private static final int SELF_DMG = 3;
    private static final int TEMPHP = 4;
    private static final int UPG_TEMPHP = 2;

    public static final String ID = makeID(Mettle.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MercenaryCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            0
    );



    public Mettle() {
        super(ID, info);

        setDamage(3);
        setMagic(TEMPHP, UPG_TEMPHP);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(p, new DamageInfo(p, SELF_DMG, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.SHIELD));
        addToBot(new AddTemporaryHPAction(p, p, magicNumber));
    }



}
