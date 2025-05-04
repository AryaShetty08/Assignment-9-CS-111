/**
 * 
 * HeartTransplant class
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {

        // WRITE YOUR CODE HERE
        patients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {

        // WRITE YOUR CODE HERE
        return patients;
     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        // WRITE YOUR CODE HERE
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        // WRITE YOUR CODE HERE
        return survivabilityByCause;
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        // WRITE YOUR CODE HERE
        patients = new Patient[numberOfLines];
        for(int i = 0; i < numberOfLines; i++)
        {
            int id = StdIn.readInt();
            int ethnicity = StdIn.readInt();
            int gender = StdIn.readInt();
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int stateOfHealth = StdIn.readInt();
            Patient test = new Patient(id, ethnicity, gender, age, cause, urgency, stateOfHealth);
            patients[i] = test;

        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        // WRITE YOUR CODE HERE
        survivabilityByAge = new SurvivabilityByAge();
        for(int i = 0; i<numberOfLines; i++)
        {
            int age = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByAge.addData(age, year, rate);
        }
        
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        // WRITE YOUR CODE HERE
        survivabilityByCause = new SurvivabilityByCause();
        for(int i = 0; i<numberOfLines; i++)
        {
            int cause = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByCause.addData(cause, year, rate);
        }
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        // WRITE YOUR CODE HERE
        int counter1 = 0;
        int counter2 = 0;

        for(int i = 0; i < patients.length; i++)
        {
            if(patients[i].getAge() >= age)
            {
                counter1++;
            }
        }

        Patient[] p1 = new Patient[counter1];

        for(int i = 0; i < patients.length; i++)
        {
            if(patients[i].getAge() >= age)
            {
                p1[counter2] = patients[i];
                counter2++;
            }
        }

        if(counter1 != 0)
        {
            return p1;
        }
        else 
        {
            return null;
        }

    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {

        // WRITE YOUR CODE HERE
        int counter1 = 0;
        int counter2 = 0;

        for(int i = 0; i < patients.length; i++)
        {
            if(patients[i].getCause() == cause)
            {
                counter1++;
            }
        }

        Patient[] p2 = new Patient[counter1];

        for(int i = 0; i < patients.length; i++)
        {
            if(patients[i].getCause() == cause)
            {
                p2[counter2] = patients[i];
                counter2++;
            }
        }

        if(counter1 != 0)
        {
            return p2;
        }
        else
        {
            return null;
        }

    }

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {

        // WRITE YOUR CODE HERE
        int counter1 = 0;
        int counter2 = 0;

        for(int i = 0; i < patients.length; i++)
        {
            if(patients[i].getUrgency() == urgency)
            {
                counter1++;
            }
        }

        Patient[] p3 = new Patient[counter1];

        for(int i = 0; i < patients.length; i++)
        {
            if(patients[i].getUrgency() == urgency)
            {
                p3[counter2] = patients[i];
                counter2++;
            }
        }

        if(counter1 != 0)
        {
            return p3;
        }
        else
        {
            return null;
        }

    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 
    public Patient getPatientForTransplant () {

	// WRITE YOUR CODE HERE
    patients = getPatientsByUrgency(8);
    int counter1 = 0;
    int counter2 = 0;

    for(int i = 0; i < patients.length; i++)
    {
        if(patients[i].getNeedHeart() == true)
        {
            counter1++;
        }
    }

    Patient[] urgentP = new Patient[counter1];
    
    for(int i = 0; i < patients.length; i++)
    {
        if(patients[i].getNeedHeart() == true)
        {
            urgentP[counter2] = patients[i];
            counter2++;
        }
    }
    double best = 0;
    Patient chosenBest = null;

    for(int i = 0; i < urgentP.length; i++)
    {
        double ageSurvive = survivabilityByAge.getRate(urgentP[i].getAge(), urgentP[i].getStateOfHealth());
        double causeSurvive = survivabilityByCause.getRate(urgentP[i].getCause(), urgentP[i].getStateOfHealth());
            if((ageSurvive + causeSurvive)/2.0 > best)
            {
                best = (ageSurvive + causeSurvive)/2.0;
                chosenBest = patients[i];
            }
    }
    chosenBest.setNeedHeart(false);
	return chosenBest;
    }
}
