package g58112.webg5.bmi.service;

import org.springframework.stereotype.Service;

@Service
public class BMIService {

    public double computeBMI(int tailleCM, int poids) {
        double tailleM = tailleCM / 100.0;
        double bmi = poids / (tailleM * tailleM);
        return Math.round(bmi * 10)/10.0;
    }
    public String computeCategory(double bmi, String gender) {
        if ("woman".equals(gender)) {
            bmi++;
        }
        if (bmi < 16.5) {
            return "famine";
        }
        if (bmi < 18.5) {
            return "maigreur";
        }
        if (bmi < 25) {
            return "corpulence normale";
        }
        if (bmi < 30) {
            return "surpoids";
        }
        if (bmi < 35) {
            return "obésité modérée";
        }
        if (bmi < 40) {
            return "obésité sévère";
        }
        return "obésité morbide";
    }

}

