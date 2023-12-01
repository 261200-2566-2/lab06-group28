public class Lab05_06 {
    public static void main(String[] args) {
        Mage earn = new Mage(5,130,"Earn","mage");
        Tank win = new Tank(5,20,"Win", "Tank");
        Mage Enermy = new Mage(5,10,"Plam","Mage");

        Ring ring  = new Ring(10,"RING");
        Boot boot = new Boot(10,"BOOT");
        // show status
        earn.showstatus();
        win.showstatus();
        Enermy.showstatus();
        // level up, buff_atk (Mage)
        earn.levelup_Character(Enermy);
        earn.buff_atk(Enermy);
        Enermy.showstatus();
        // attack
        Enermy.attack(win);
        win.showstatus();
        // heal (Mage)
        earn.heal(win);
        win.showstatus();
        // defence (Tank)
        win.defence(earn);
        earn.showstatus();
        // Ring
        earn.equip_Ring(ring);
        earn.showstatus();
        // Boot
        win.equip_Boot(boot);
        win.showstatus();


    }
}