package godofjava.a;

// GodOfJava Vol1. 13장 연습문제 2
public enum HealthInsurance {
    LEVEL_ONE(1000, 1.0),
    LEVEL_TWO(2000, 2.0),
    LEVEL_THREE(3000, 3.2),
    LEVEL_FOUR(4000,4.5),
    LEVEL_FIVE(5000, 5.6),
    LEVEL_SIX(6000, 7.1);

    private final long maxSalary;
    private final double ratio;

    HealthInsurance(long maxSalary, double ratio) {
        this.maxSalary = maxSalary;
        this.ratio = ratio;
    }

    public long getMaxSalary() {
        return maxSalary;
    }

    public double getRatio() {
        return ratio;
    }

    public static HealthInsurance getHealthInsurance(int salary) {
        if (salary < HealthInsurance.LEVEL_ONE.maxSalary) {
            return HealthInsurance.LEVEL_ONE;
        } else if (salary < HealthInsurance.LEVEL_TWO.maxSalary) {
            return HealthInsurance.LEVEL_TWO;
        } else if (salary < HealthInsurance.LEVEL_THREE.maxSalary) {
            return HealthInsurance.LEVEL_THREE;
        } else if (salary < HealthInsurance.LEVEL_FOUR.maxSalary) {
            return HealthInsurance.LEVEL_FOUR;
        } else if (salary < HealthInsurance.LEVEL_FIVE.maxSalary) {
            return HealthInsurance.LEVEL_FIVE;
        } else if (salary < HealthInsurance.LEVEL_SIX.maxSalary)  {
            return HealthInsurance.LEVEL_SIX;
        } else {
            return HealthInsurance.LEVEL_SIX;
        }
    }

    public static void main(String[] args) {
        int[] salaryArray = new int[]{1500, 5500, 8000};
        HealthInsurance[] insurances = new HealthInsurance[3];
        insurances[0] = HealthInsurance.getHealthInsurance(salaryArray[0]);
        insurances[1] = HealthInsurance.getHealthInsurance(salaryArray[1]);
        insurances[2] = HealthInsurance.getHealthInsurance(salaryArray[2]);

        for (int loop = 0; loop < 3; loop++) {
            System.out.println(
                    salaryArray[loop] + " = " + insurances[loop] + ", " + insurances[loop].getRatio()
            );
        }
    }
}
