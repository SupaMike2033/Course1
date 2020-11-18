package lesson15;

public class Main {
    static final int HEAD_COUNT = 5;                // размер массива, человек
    static final int FILTER_AGE = 40;               // возраст для фильтрации

    static Employee[] heads = new Employee[HEAD_COUNT];

    public static void main(String[] args) {
        runProg();
    }

    private static void runProg() {
        fullFillIdiots();                   // получились такие смешные сотрудники, что я не смог удержаться :)

        printIdiots(0);
        printIdiots(FILTER_AGE);            // передаётся значение, старше которого распечатывать (0 - для всех)

    }

    private static void fullFillIdiots() {
        for(int i = 0; i < heads.length; i++) {
//            heads[i] = new Employee(null, null, null, null, 0, 0);
            heads[i] = new Employee();                          // вызываем перегруженный конструктор
            heads[i].name = FillData.generateName();
            heads[i].position = FillData.generateProf();
            heads[i].phone = FillData.generatePhone();
            heads[i].email = FillData.generateEmail();
            heads[i].salary = FillData.generateSalary();
            heads[i].age = FillData.generateAge();
        }
    }

    private static void printIdiots(int maxAge) {
        System.out.println(maxAge == 0 ? "Весь список:" : ("Фильтр = " + maxAge));
        for (int i = 0; i < heads.length; i++) {
            if(heads[i].age > maxAge)
                heads[i].printEmployee();
        }
    }
}
