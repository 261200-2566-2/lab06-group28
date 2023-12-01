public class Ring extends Accessories{

    /** Create Ring.
     */
    Ring(int level, String name) {
        super(level, name);
    }

    /** Increase Character's Mana.
     * effect: when equip the Ring Character's Mana will be increase.
     *          But the maximum to be increased is 1000.
     */
    void increaseMana(Characters c){
        c.assign_Element("Mana",c.getElement("Mana")+50+(0.5*this.getLV()));
        if(c.getElement("Mana") >= 1000) c.assign_Element("Mana",1000);
    }

}
