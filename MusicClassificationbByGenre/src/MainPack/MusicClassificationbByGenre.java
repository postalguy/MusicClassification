

package MainPack;

import Utilities.ArrayTools;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.DataSet;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TrainingSetImport;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author iamsmile
 */
public class MusicClassificationbByGenre {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Statistics stat = new Statistics(0,0, 0, 0);
        String trainingSetFileName = "Music.txt";
        int inputsCount = 8;
        int outputsCount = 4;
        

        System.out.println("Lancement :");
        System.out.println("Set d'apprentissage =" + trainingSetFileName);

        // create training set
        DataSet trainingSet = null;
        try {
            trainingSet = TrainingSetImport.importFromFile(trainingSetFileName, inputsCount, outputsCount, ",");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Error reading file or bad number format!");
        }


        // create multi layer perceptron
        System.out.println("Création du réseau de neurones: \n\tEntrées : 8\n\tCouches cachées : 20\n\tSorties : 4");
        //8 iputs 
        int inp=8;
        //20 Hidden layers 
        int HL=20;
        //4 outputs 
        int outp=4;
        MultiLayerPerceptron neuralNet = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, inp, HL, outp);

        // set learning parameters
       double learningRate = 0.5;  // learning rate at minimum error 0.5
       double momentum= 0.8;// momentum at minimum error 0.8
        MomentumBackpropagation learningRule = (MomentumBackpropagation) neuralNet.getLearningRule();
        learningRule.setLearningRate(learningRate);
        learningRule.setMomentum(momentum);

        // learn the training set
        System.out.println("------------------------------------------------------------");
         System.out.println("Apprentissage du réseau avec un taux de "+learningRate +" et un élan "+ momentum);
        neuralNet.learn(trainingSet);
        System.out.println("Fait !");

        // test perceptron
        System.out.println("Test avec le fichier d'entrée donne : ");
        testMusicClassification(neuralNet, trainingSet , stat);
       System.out.println(stat.toString());
        
    }

    public static void testMusicClassification(NeuralNetwork nnet, DataSet dset , Statistics st) {

        for (DataSetRow trainingElement : dset.getRows()) {

          
            nnet.setInput(trainingElement.getInput());
            nnet.calculate();
            double[] networkOutput = nnet.getOutput();
            System.out.println("Entrée: " + Arrays.toString(trainingElement.getInput()));
            System.out.println("-> Sortie: " + Arrays.toString(networkOutput));
           String out = ArrayTools.getGenre(networkOutput, st);
            System.out.println("--> le genre est = "+out);  
          
        }

    }
}
