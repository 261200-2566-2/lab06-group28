public class Accessories implements Accessory{
    private int level = 1;
    private String name = null;

    /** Create an Accessory.
     * @param level should be between 0 and 5.
     */
    Accessories(int level, String name){
        this.level = Math.min(level, 5);
        this.name = name;
    }

    /** Decrease Character's speed.
     * effect: if Character's speed less than 125, Character's speed will be decreased.
     */
    @Override
    public void decrease_speed(Characters c) {
        if(c.getElement("speed") > 125){
            c.assign_Element("speed",c.getElement("speed")-5*(0.5*this.getLV()));
        }
    }

    /** Power up Character's HP.
     * effect: if Character's HP less than 500, Character's HP will be increased.
     */
    @Override
    public void powerup_HP(Characters c) {
        if(c.getElement("HP") < 500){
            c.assign_Element("HP", c.getElement("HP")+(this.level*0.8));
        }
    }

    /** Get Accessory's name(type).
     * @return Accessory's name(type).
     */
    @Override
    public String getName() {
        return this.name;
    }

    /** Get Accessory's Level.
     * @return Accessory's Level.
     */
    @Override
    public int getLV() {
        return this.level;
    }

}
