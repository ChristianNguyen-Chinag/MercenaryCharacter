package mercenarycharacter.cards.skill;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mercenarycharacter.cards.BaseCard;
import mercenarycharacter.character.MercenaryCharacter;
import mercenarycharacter.powers.MomentumPower;
import mercenarycharacter.util.CardStats;

public class Breather extends BaseCard {
        private static final int MOMENTUM = -4;
        private static final int BLOCK = 8;
        private static final int UPG_BLOCK = 3;

        public static final String ID = makeID(Breather.class.getSimpleName());

        private static final CardStats info = new CardStats(
                MercenaryCharacter.Meta.CARD_COLOR,
                CardType.SKILL,
                CardRarity.COMMON,
                CardTarget.SELF,
                1
        );

        public  Breather() {
            super(ID,info);
            setMagic(MOMENTUM);
            setBlock(BLOCK, UPG_BLOCK);
        }


        @Override
        public void use(AbstractPlayer p, AbstractMonster m) {
            addToBot(new ApplyPowerAction(p, p, new MomentumPower(p, magicNumber)));
            addToBot(new GainBlockAction(p, p, block));
        }
}
