package mercenarycharacter.relics;


import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import mercenarycharacter.character.MercenaryCharacter;

import static mercenarycharacter.TheMercenaryMod.makeID;

public class CeremonialHelm extends BaseRelic{
    private static final String NAME = "CeremonialHelm";
    public static final String ID = makeID(NAME);

    private static final int TEMPHP = 4;

    public CeremonialHelm(){
        super(ID, NAME, MercenaryCharacter.Meta.CARD_COLOR, RelicTier.STARTER, LandingSound.CLINK);
    }

    @Override
    public void atBattleStart() {
        this.flash();
        addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        addToBot(new AddTemporaryHPAction(AbstractDungeon.player, AbstractDungeon.player, TEMPHP));
    }

    @Override
    public String getUpdatedDescription(){
        return String.format(DESCRIPTIONS[0], TEMPHP);
    }
}
