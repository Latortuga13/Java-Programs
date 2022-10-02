public class MyCalendar {
    MyTreeMap<Integer, Integer> calendar;
    
    public MyCalendar() {
        // TODO
        calendar=new MyTreeMap<>();
    }
    /**
         * This method is used for determining whether or not an event is
         * bookeable
         * @return If it is possible to book the event
         */
    public boolean book(int start, int end) {
        if(start<0 || start>=end){
            throw new IllegalArgumentException("illegal input detected");
        }
        Integer flokey=calendar.floorKey(start);
        Integer ceikey=calendar.ceilingKey(start);
        if(flokey==null){
            if(ceikey==null){
                calendar.put(start,end);
                return true;
            }
            else{
                if(ceikey>=end){
                    calendar.put(start,end);
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        Integer floValue=calendar.get(flokey);
        if(ceikey==null){
            if(floValue<=start){
                calendar.put(start,end);
                return true;
            }
            else{
                return false;
            }
        }
        if(floValue<=start && ceikey>=end){
            calendar.put(start,end);
            return true;
        }
        // TODO
        return false;
    }

    public MyTreeMap getCalendar(){
        return this.calendar;
    }
}