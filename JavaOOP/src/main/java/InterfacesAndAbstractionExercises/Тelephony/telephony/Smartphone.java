package InterfacesAndAbstractionExercises.Тelephony.telephony;

import java.util.List;

public class Smartphone implements Browsable,Callable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (hasDigit(url)){
                sb.append("Invalid URL!").append(System.lineSeparator());
            }else{
                sb.append(String.format("Browsing: %s!%n",url));
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String num : numbers) {
            if (!onlyDigit(num)){
                sb.append("Invalid number!").append(System.lineSeparator());
            }else{
                sb.append(String.format("Calling... %s%n",num));
            }
        }

        return sb.toString().trim();
    }
    private boolean hasDigit(String url){
        for (char symbol : url.toCharArray()) {
            if (Character.isDigit(symbol)){
                return true;
            }
        }
        return false;
    }
    private boolean onlyDigit(String numbers){
        for (char symbol : numbers.toCharArray()) {
            if (!Character.isDigit(symbol)){
                return false;
            }
        }
        return true;
    }
}
