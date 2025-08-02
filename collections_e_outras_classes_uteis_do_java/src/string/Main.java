package string;

public class Main {
    public static void main(String[] args) {
        var value = "joao fulano de tal";
        // Transformando a primeira letra em maiúscula e o restante em minúscula
        var result = value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
        System.out.println(result);

        var values = value.split(" ");
        var finalValue = "";
        for (var v : values) {
            if (!(v.length() < 3)) {
                var refactoredValue = v.substring(0, 1).toUpperCase() + v.substring(1).toLowerCase();
                System.out.println(refactoredValue);
                finalValue += refactoredValue + " ";
            } else {
                System.out.println(v.toLowerCase());
                finalValue += v + " ";
            }
        }

        System.out.println(finalValue);

    }
}
