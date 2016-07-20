/**
 * Created by theo on 20/07/16.
 */
public class Cell implements Cloneable {
    boolean isAlive = false;
    byte state = 0; //0 blank, 1 cell, 2 block, 3 waste?
    int generationsSurvived = 0;
    byte lowerPopulationBound = 2;
    byte upperPopulationBound = 3;
    byte splitLowerBound = 5;
    byte splitUpperBound = 1;
    int foodConsumption = 1;
    byte generationsBetweenSplit = 1;

    byte lowerTempBound;
    byte upperTempBound;
    byte humidityBound;
    byte lowerPhBound;
    byte upperPhBound;
    byte radiationBound;
    byte toxicityBound;
    byte decayBound;

    int foodAbundance = 10000;
    byte decay;

    void setEnvironmentBounds(byte[] bounds) {
        lowerTempBound =  bounds[0];
        upperTempBound = bounds[1];
        humidityBound = bounds[2];
        lowerPhBound = bounds[3];
        upperPhBound = bounds[4];
        radiationBound = bounds[5];
        toxicityBound = bounds[6];
        decayBound = bounds[7];
    }

    void setPopulationBounds(byte[] bounds) {
        lowerPopulationBound = bounds[0];
        upperPopulationBound = bounds[1];
        splitLowerBound = bounds[2];
        splitUpperBound = bounds[3];
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
        //Super works here because the class only contains primitives
//        final Cell clone = (Cell) super.clone();
//
//        clone.isAlive = isAlive;
//        clone.state = state;
//        clone.generationsSurvived = generationsSurvived;
//        clone.foodConsumption = foodConsumption;
//        clone.foodAbundance = foodAbundance;
//        clone.decay = decay;
//        clone.generationsBetweenSplit = generationsBetweenSplit;
//
//        clone.setEnvironmentBounds(new byte[]{
//                lowerTempBound, upperTempBound, humidityBound, lowerPhBound, upperPhBound, radiationBound, toxicityBound, decayBound
//        });
//        clone.setPopulationBounds(new byte[]{
//                lowerPopulationBound, upperPopulationBound, splitLowerBound, splitUpperBound
//        });
//
//        return clone;
    }
}
