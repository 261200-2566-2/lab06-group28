import java.text.DecimalFormat;

public class Characters implements Character{
    private int level = 1;
    private double HP, speed, deff, atk, Mana;
    private boolean dead = false, equipR = false, equipB = false;
    private String name = null, CL = null;

    /**
     * Create a Characters.
     * @param level should be between 0 and 5.
     * @param CL get only words "Mage" or "Tank". (don't care the size)
     */
    Characters (int level, double speed, String name, String CL){
        this.level = Math.min(level, 5);
        this.speed = speed;
        this.name = name;
        this.CL = CL;
        if(CL.equalsIgnoreCase("TANK")){
            deff = 150+10*level;
            HP = 200 + 20*level;
            Mana = 100 + 10*level;
            atk = (0.5*deff)+10*level;
        }
        if(CL.equalsIgnoreCase("MAGE")){
            deff = 50 + 10*level;
            HP = 100 + 20*level;
            Mana = 200+10*level;
            atk = (0.5*Mana)+10*level;
        }
    }

    /**
     *  attack the other Characters
     *  effect: "Can't attack.Your atk is too low." is printed when your atk is lower than your opponent.
     *  effect: "Your target is dead." is printed when your opponent has HP=0
     *  effect: "Your Character's name attack your opponent's name." is printed
     *          when your attack hit your opponent. Your opponent HP will decrease
     *          and if your opponent HP <= 0 the variable dead will change to be true.
     *
     */
    @Override
    public void attack(Characters c) {
        if(!c.dead){
            if(c.deff >= this.atk){
                System.out.println("Can't attack.Your atk is too low.");
            }else{
                c.HP -= this.atk - c.deff;
                if(c.HP <= 0){
                    c.dead = true;
                    c.HP = 0;
                }
                System.out.println(this.name + " attack " + c.name);
            }
        }else{
            System.out.println("Your target is dead.");
        }
    }

    /** update the status of Character when equip Ring.
     *  effect: "Your Character's name equip RING" is printed when the Character equip Ring.
     *  effect: the Mana, HP status will increase but speed will decrease
     *          and equipR will change to be true.
     */
    @Override
    public void equip_Ring(Ring r) {
        r.increaseMana(this);
        r.decrease_speed(this);
        r.powerup_HP(this);
        equipR = true;
        System.out.println(this.name + " equip " + r.getName());
    }

    /** update the status of Character when equip Ring.
     *  effect: "Your Character's name equip BOOT" is printed when the Character equip Boot.
     *  effect: the speed, HP status will increase and equipB will change to be true.
     */
    @Override
    public void equip_Boot(Boot b) {
        b.speedInc(this);
        b.powerup_HP(this);
        equipB = true;
        System.out.println(this.name + " equip " + b.getName());
    }

    /** show the status of the Character.
     *  effect: All the status will be printed.
     */
    @Override
    public void showstatus() {
        System.out.println("------------------------------------------------------");
        if(!this.dead){
            String speed = new DecimalFormat("##.##").format(this.speed);
            System.out.println("NAME: "+this.name+"\nLevel: " + this.level
                    + "\nHP: " + this.HP + "\nmana: " + this.Mana + "\nAtk: " + this.atk
                    + "\nSpeed: " + speed +"\nDeff: " + this.deff + "\nClass: " + this.CL);
            if(equipR) System.out.println(this.name + " equip RING.");
            else if(equipB) System.out.println(this.name + " equip BOOT.");
        }else{
            System.out.println(this.name + " is dead.");
        }

        System.out.println("------------------------------------------------------");
    }

    /** Update status of the Character.
     *  effect: the status HP, deff, atk, Mana, and speed will increase by level.
     *  effect: HP is max at 500. atk, deff, and Mana is max at 1000.
     */
    @Override
    public void update() {
        HP += 10*(level*0.5);
        deff += 20*(level*0.25);
        atk += 50*(level*0.25);
        Mana += 25*(level*0.5);
        speed += 10*(level*0.8);
        if(HP > 500) HP = 500;
        if(atk >= 1000) atk = 1000;
        if(deff >= 1000) deff = 1000;
        if(Mana >= 1000) Mana = 1000;
    }

    /** Get the value of the status that is double.
     * @param s receives only "HP", "deff", "atk", "Mana" or "speed". (don't care size)
     * @return the value of the status "s". if the input "s" is not the status, it will 0.
     */
    @Override
    public double getElement(String s) {
        if(s.equalsIgnoreCase("HP")){
            return this.HP;
        }else if(s.equalsIgnoreCase("deff")){
            return this.deff;
        }else if(s.equalsIgnoreCase("ATK")){
            return this.atk;
        }else if(s.equalsIgnoreCase("MANA")){
            return this.Mana;
        }else if(s.equalsIgnoreCase("speed")){
            return this.speed;
        }else{
            return 0;
        }
    }

    /** Get the "name" and "CL" of the
     * @param s must be only "name" or "CL".
     * @return if "s" is "name"  Character's name however if "s" is "CL"
     *          Character's CL. But if the input isn't "name" or "CL"  null.
     */
    @Override
    public String getName_CL(String s) {
        if(s.equalsIgnoreCase("name")){
            return this.name;
        }else if(s.equalsIgnoreCase("CL")){
            return this.CL;
        }else{
            return null;
        }
    }

    /** Get Character's level.
     * @return Character's level.
     */
    @Override
    public int getLv() {
        return this.level;
    }

    /**
     * @param s receive only the status of the Character except "name", "CL". (don't care size)
     * effect: change the value of the status "s" to be "n".
     */
    @Override
    public void assign_Element(String s, double n) {
        if(s.equalsIgnoreCase("HP")){
            this.HP = n;
        }else if(s.equalsIgnoreCase("deff")){
            this.deff = n;
        }else if(s.equalsIgnoreCase("ATK")){
            this.atk = n;
        }else if(s.equalsIgnoreCase("MANA")){
            this.Mana = n;
        }else if(s.equalsIgnoreCase("speed")){
            this.speed = n;
        }else if(s.equalsIgnoreCase(("level"))){
            this.level = (int)n;
        }
    }


}
