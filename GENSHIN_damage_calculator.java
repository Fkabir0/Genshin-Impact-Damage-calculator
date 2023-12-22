import java.util.Scanner;

public class GENSHIN_damage_calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What does your character scale off of?");
        System.out.println("1. ATK");
        System.out.println("2. DEF");
        System.out.println("3. Max HP");
        System.out.println("4. EM (Elemental Mastery)");
 
        int scalingChoice = scanner.nextInt();
        double baseDamage = 0.0;
        double talentPercentage = 0.0;
        
        switch (scalingChoice) {
            case 1:
                System.out.print("Enter your ATK amount: ");
                double atkAmount = scanner.nextDouble();
                System.out.print("Enter your ATK scaling percentage: ");
                talentPercentage = scanner.nextDouble() / 100.0;
                baseDamage = calculateBaseDamage(atkAmount, talentPercentage);
                break;
            case 2:
                System.out.print("Enter your DEF amount: ");
                double defAmount = scanner.nextDouble();
                System.out.print("Enter your DEF scaling percentage: ");
                talentPercentage = scanner.nextDouble() / 100.0;
                baseDamage = calculateBaseDamage(defAmount, talentPercentage);
                break;
            case 3:
                System.out.print("Enter your Max HP amount: ");
                double maxHpAmount = scanner.nextDouble();
                System.out.print("Enter your Max HP scaling percentage: ");
                talentPercentage = scanner.nextDouble() / 100.0;
                baseDamage = calculateBaseDamage(maxHpAmount, talentPercentage);
                break;
            case 4:
                System.out.print("Enter your EM amount: ");
                double emAmount = scanner.nextDouble();
                System.out.print("Enter your EM scaling percentage: ");
                talentPercentage = scanner.nextDouble() / 100.0;
                baseDamage = calculateBaseDamage(emAmount, talentPercentage);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(1);
        }
        
        System.out.print("Enter your CRIT percentage: ");
        double CRIT = scanner.nextDouble() / 100.0;
        
        System.out.print("Enter your DMG Reduction Target: ");
        double DMGReductionTarget = scanner.nextDouble();

        System.out.print("Enter the base damage multiplier: ");
        double BaseDMGMultiplier = scanner.nextDouble();

        System.out.print("enter the additive base damage bonus: ");
        double AdditiveBaseDMGBonus = scanner.nextDouble();

        System.out.print("enter the amount of elemental or phsyical damage bonus you have: ");
        double DMGBonus = scanner.nextDouble();

        System.out.println("enter the enemies deffence multiplier: ");
        double EnemyDefMult = scanner.nextDouble();

        // Calculate total damage using the formula
        double totalDamage = calculateTotalDamage(baseDamage, CRIT, DMGReductionTarget, BaseDMGMultiplier, AdditiveBaseDMGBonus, DMGBonus, EnemyDefMult );

        System.out.println("Total Damage: " + totalDamage);
        
        scanner.close();
    }

    private static double calculateBaseDamage(double attributeAmount, double talentPercentage) {
        return attributeAmount * talentPercentage;
    }

    private static double calculateTotalDamage(double baseDamage, double CRIT, double DMGReductionTarget, double BaseDMGMultiplier, 
                                double AdditiveBaseDMGBonus, double DMGBonus, double EnemyDefMult   ) {
 
        // total damage calculation 
        double totalDamage = (baseDamage * BaseDMGMultiplier + AdditiveBaseDMGBonus)
                * (1 + DMGBonus - DMGReductionTarget) * CRIT * EnemyDefMult;

        return totalDamage;
    }
}
