package Nyt_eks_på_traade;

public class Main {
    public static void main(String[] args) {
        CommenClass commenClass = new CommenClass();
        System.out.println("Så er vi igang");
        ThreadClass1 threadClass1 = new ThreadClass1(commenClass);
        ThreadClass2 threadClass2 = new ThreadClass2(commenClass);
        threadClass1.start();
        threadClass2.start();
    }
}
