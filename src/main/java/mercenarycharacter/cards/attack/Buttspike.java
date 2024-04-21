package mercenarycharacter.cards.attack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;
import mercenarycharacter.cards.BaseCard;
import mercenarycharacter.character.MercenaryCharacter;
import mercenarycharacter.util.CardStats;

public class Buttspike extends BaseCard {

    private static final int DAMAGE = 2;
    private static final int UPG_DAMAGE = 2;
    private static final int VIGOR = 2;
    private static final int UPG_VIGOR = 2;

    public static final String ID = makeID(Buttspike.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MercenaryCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public Buttspike(){
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(VIGOR, UPG_VIGOR);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new VigorPower(p, magicNumber), magicNumber,AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }
}
