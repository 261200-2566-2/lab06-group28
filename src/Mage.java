public class Mage extends Characters{
    /** Create Characters has class Mage.
     * @param CL have to be only "Mage".
     */
    Mage(int level, double speed, String name,String CL) {
        super(level, speed, name, CL);
    }

    /** Heal the Character (include herself).
     *  effect: increase Character's HP by Mage's Mana/2.0 but maximum to be increased is 1000.
     *  effect: "Mage's name heal the Character's name by the amount of Mage's Mana/2.0" is printed
     *          if Character's HP <= 500.
     *  effect: "Your HP is max." is print if Character's HP is greater than 500.
     */
    void heal(Characters c){
        if(c.getElement("HP") <= 500){
//            c.HP += this.Mana/2.0;
            c.assign_Element("HP",c.getElement("HP")+this.getElement("Mana")/2.0);
            if(c.getElement("HP") >= 1000) c.assign_Element("HP",1000);
            System.out.println(this.getName_CL("name") + " heal " + c.getName_CL("name") + " "
                    + this.getElement("Mana")/2.0);
        }else{
            System.out.println("Your HP is max.");
        }
    }

    /** Level up the Character (include herself)
     *  effect: increase the level by 1 then update the status. The maximum of the level to be increased is 100.
     *  effect: "Mage's name level up Character's name" is printed if Character's level less than 100.
     *  effect: "Your level is max." is printed if Character's level more than 100.
     */
    void levelup_Character(Characters c){
        if(c.getLv() < 100){
           c.assign_Element("level", c.getLv()+1);
           if(c.getLv() >= 100) c.assign_Element("level",100);
           c.update();
           System.out.println(this.getName_CL("name") + " level up " + c.getName_CL("name"));
        }else{
            System.out.println("Your level is max.");
        }
    }

    /** Buff atk status of the Character(include herself)
     * effect: increase Character's atk by 40% of Mage's Mana. The maximum that can be increased is 1000.
     * effect: "Mage's name buff atk Character's name by 40% of Mage's Mana" is printed if Character's atk < 1000.
     * effect: "Your atk is max." is printed if Character's atk is more than 1000.
     */
    void buff_atk(Characters c){
        if(c.getElement("atk") < 1000){
//            c.atk += 0.4*this.Mana;
            c.assign_Element("atk",c.getElement("atk")+0.4*this.getElement("Mana"));
            if(c.getElement("atk") >= 1000){
                c.assign_Element("atk",1000);
            }
            System.out.println(this.getName_CL("name") + " buff atk " + c.getName_CL("name") + " " +
                    0.4*this.getElement("Mana"));
        }else{
            System.out.println("Your atk is max.");
        }
    }

}
