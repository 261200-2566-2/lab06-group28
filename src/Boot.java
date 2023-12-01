public  class Boot extends Accessories{
    /** Create Boot.
     */
    Boot(int level, String name) {
        super(level, name);
    }

    /** Increase Character's speed.
     * effect: when equip the Boot Character's speed will be increased.
     */
    void speedInc(Characters c){
        c.assign_Element("speed",c.getElement("speed")+50+(this.getLV()*0.5));
    }
}
