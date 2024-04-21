package mercenarycharacter.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static mercenarycharacter.TheMercenaryMod.makeID;

public class MomentumPower extends BasePower{
    public static final String POWER_ID = makeID(MomentumPower.class.getSimpleName());
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    protected int MAX_STACKS = 10;

    public MomentumPower(AbstractCreature owner, int amount) {

        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    @Override
    public void stackPower(int stackAmount){
        this.fontScale=8.0F;

        this.amount += stackAmount;

        if (this.amount >= MAX_STACKS) {
            this.amount = MAX_STACKS;
        }

    }

    @Override
    public void reducePower(int reduceAmount){


        this.fontScale=8.0F;

        this.amount -= reduceAmount;

        if (this.amount <= 0){
            this.amount = 0;
            this.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
        }



    }

    public float atDamageGive(float damage, DamageInfo.DamageType type) {
        return type == DamageInfo.DamageType.NORMAL ? damage + (float)this.amount : damage;
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK) {
            flash();
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
        }

    }

    public void upgradeDescription(){
        this.description = String.format(DESCRIPTIONS[0], this.amount, MAX_STACKS);
    }
}
