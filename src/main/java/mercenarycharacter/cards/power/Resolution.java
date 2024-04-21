package mercenarycharacter.cards.power;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;
import com.megacrit.cardcrawl.vfx.combat.InflameEffect;
import mercenarycharacter.cards.BaseCard;
import mercenarycharacter.character.MercenaryCharacter;
import mercenarycharacter.powers.ResolutionPower;
import mercenarycharacter.util.CardStats;

public class Resolution extends BaseCard {

    private static final int Vigor = 3;

    private static final String ID = makeID(Resolution.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MercenaryCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );

    public Resolution(){
        super(ID, info);
        setMagic(Vigor);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new VFXAction(p, new InflameEffect(p), 1.0F));
        if (upgraded)
            addToBot(new ApplyPowerAction(p, p, new VigorPower(p, magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new ResolutionPower(p, Vigor)));
    }
}
