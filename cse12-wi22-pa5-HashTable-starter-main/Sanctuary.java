/**
 * TODO: Complete the solution for Sanctuary
 */
import java.util.HashMap;
import java.util.Set;

public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    public Sanctuary(int maxAnimals, int maxSpecies) {
        if(maxAnimals<0 || maxSpecies<0){
            throw new IllegalArgumentException("You put an illegal input in");
        }
        this.maxAnimals=maxAnimals;
        this.maxSpecies=maxSpecies;
        sanctuary=new HashMap<>();
    }

    public int getNum(String species) {
        if(species==null){
            throw new IllegalArgumentException();
        }
        return sanctuary.get(species);
    }
    
    public int getTotalAnimals() {
        Object [] values = sanctuary.values().toArray();
        int toReturn=0;
        for(int i=0;i<values.length; i++){
            toReturn=(int)values[i]+toReturn;
        }
        return toReturn;
    }
    
    public int getTotalSpecies() {
        return sanctuary.size();
    }

    public int rescue(String species, int num) {
        int x=num;
        if(species==null || num<=0){
            throw new IllegalArgumentException("You put an illegal input in");
        }
        if(getTotalAnimals()<maxAnimals && getTotalSpecies()<maxSpecies){
            if(num+getTotalAnimals()>maxAnimals){
                x=num+getTotalAnimals()-maxAnimals;
                return x;
            }
            sanctuary.put(species, x);
        }
        return 0;
    }

    public void release(String species, int num) {
        if(!sanctuary.containsKey(species)||num<=0
        ||num>sanctuary.get(species)||species==null){
            throw new IllegalArgumentException("You put an illegal input in");
        }
        if(sanctuary.get(species)-num!=0){
            sanctuary.replace(species,sanctuary.get(species)-num);
        }
        else{
            sanctuary.remove(species);
        }
    }
}
